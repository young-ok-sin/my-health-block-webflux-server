package com.example.myhealthblock.question.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.question.QuestionService;
import com.example.myhealthblock.question.adapter.in.request.RequestQuestionEnroll;
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
}
