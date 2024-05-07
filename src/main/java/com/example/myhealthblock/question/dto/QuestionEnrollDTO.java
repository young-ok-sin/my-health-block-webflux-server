package com.example.myhealthblock.question.dto;

import com.example.myhealthblock.question.adapter.out.bodypart.BodyPart;
import com.example.myhealthblock.question.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEnrollDTO {
    String userId;
    List<BodyPart> bodyParts;
    Category category;
    String title;
    String symptom;
    String content;
    PersonalDataDTO personalData;
}
