package com.example.myhealthblock.question.dto;

import com.example.myhealthblock.question.adapter.out.bodypart.BodyPart;
import com.example.myhealthblock.question.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionEnrollDTO {
    String userId;
    List<BodyPart> bodyParts;
    Category category;
    String title;
    String symptom;
    String content;
}
