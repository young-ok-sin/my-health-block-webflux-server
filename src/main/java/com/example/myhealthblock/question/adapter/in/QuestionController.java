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
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/v1/question/enroll")
    public ResponseResult enroll(@RequestBody RequestQuestionEnroll body) {
        ResponseResult response = new ResponseResult();
        response.setResult(questionService.enroll(body));
        return response;
    }

    @GetMapping("/v1/question")
    public ResponseQuestions enroll() {
        ResponseQuestions response  = new ResponseQuestions();
        response.setQuestions(questionService.getQuestions());
        return response;
    }

    @PatchMapping("/test-0/question")
    public ResponseResult update(@RequestBody RequestQuestionUpdate body) {
        return new ResponseResult();
    }

    @DeleteMapping("/test-0/question/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        return new ResponseResult();
    }

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

    @GetMapping("/test-0/question/{questionId}")
    public ResponseQuestion get(@PathVariable Integer questionId) {
        return new ResponseQuestion();
    }
}
