package com.example.myhealthblock.question.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.question.Category;
import com.example.myhealthblock.question.QuestionService;
import com.example.myhealthblock.question.adapter.in.request.RequestQuestionEnroll;
import com.example.myhealthblock.question.adapter.in.request.RequestQuestionUpdate;
import com.example.myhealthblock.question.adapter.in.response.ResponseQuestionList;
import com.example.myhealthblock.question.adapter.in.response.ResponseQuestion;
import com.example.myhealthblock.question.adapter.in.response.ResponseQuestions;
import com.example.myhealthblock.question.adapter.in.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@Tag(name = "Question", description = "Endpoints for Question")
@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class QuestionController {
    private final QuestionService questionService;

    @Operation(summary = "질문 등록", description = "질문 등록")
    @PostMapping("/v1/question/enroll")
    public ResponseResult enroll(@RequestBody RequestQuestionEnroll body) {
        ResponseResult response = new ResponseResult();
        response.setResult(questionService.enroll(body));
        return response;
    }

    @Operation(summary = "질문들 조회", description = "질문들 내용까지 함께 조회")
    @GetMapping("/v1/question")
    public ResponseQuestions enroll() {
        ResponseQuestions response  = new ResponseQuestions();
        response.setQuestions(questionService.getQuestions());
        return response;
    }

    @Operation(summary = "질문 수정", description = "특정 데이터만 수정")
    @PatchMapping("/test-0/question")
    public ResponseResult update(@RequestBody RequestQuestionUpdate body) {
        return new ResponseResult(questionService.update(body.getQuestionId(), body.getTitle(), body.getSymptom(), body.getContent()));
    }

    @Operation(summary = "질문 삭제", description = "질문 삭제 <br>{questionId}는 식별자")
    @DeleteMapping("/test-0/question/{questionId}")
    public ResponseResult delete(@PathVariable Integer questionId) {
        return new ResponseResult();
    }

    @Operation(summary = "질문 목록 조회", description = "질문 식별자와 제목으로 목록 조회 <br>catetory는 게시판 카테고리<br>userId는 회원가입 아이디 <br>userId 미입력 시, 전체 목록 조회<br>userId 입력 시, 특정 회원이 작성한 질문 목록 조회")
    @GetMapping("/test-1/question/list")
    public ResponseQuestionList getTitles(
            @RequestParam Category category,
            @RequestParam(required = false) String userId
    ) {
        if (userId != null) {
//            특정 인물의 질문 리스트 조회
        } else {
//            일반 질문 리스트 조회
        }
        return new ResponseQuestionList();
    }

    @Operation(summary = "질문 조회", description = "하나의 질문 정보 조회 <br>{questionId}는 식별자 <br>질문 목록에서 선택한 하나의 질문 내용 조회")
    @GetMapping("/test-0/question/{questionId}")
    public ResponseQuestion get(@PathVariable Integer questionId) {
        return new ResponseQuestion();
    }
}
