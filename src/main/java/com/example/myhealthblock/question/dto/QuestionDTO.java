package com.example.myhealthblock.question.dto;

import com.example.myhealthblock.question.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDTO {
    Integer id;
    String uid;
    String title;
    Category category;
    String symptom;
    String content;

    public QuestionDTO(Integer id, String userId, String title, Category category, String symptom, String content) {
        this.id = id;
        this.uid = userId;
        this.title = title;
        this.category = category;
        this.symptom = symptom;
        this.content = content;
    }
}
