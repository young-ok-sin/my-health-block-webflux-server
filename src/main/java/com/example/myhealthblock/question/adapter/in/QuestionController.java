package com.example.myhealthblock.question.adapter.in;

import com.example.myhealthblock.question.QuestionService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.myhealthblock.question.dto.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/v1/question/enroll")
    public String enroll(@RequestBody QuestionEnrollDTO body) {
        return questionService.enroll(body);
    }
}
