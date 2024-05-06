package com.example.myhealthblock.question.adapter.in;

import com.example.myhealthblock.question.QuestionService;
import org.springframework.web.bind.annotation.*;

import com.example.myhealthblock.question.dto.*;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/v1/question/enroll")
    public String enroll(@RequestBody QuestionEnrollDTO body) {
        return questionService.enroll(body);
    }

    @GetMapping("/v1/question")
    public Map<String, QuestionDTO[]> enroll() {
        Map<String, QuestionDTO[]> map  = new HashMap<String, QuestionDTO[]>();
        map.put("questions", questionService.getQuestions());
        return map;
    }

}
