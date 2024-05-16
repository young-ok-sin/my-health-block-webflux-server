package com.example.myhealthblock.question.adapter.in.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseQuestionList {
    private QuestionTitle[] list;

    @Getter
    @Setter
    public static class QuestionTitle {
        private int questionId;
        private String title;
    }
}
