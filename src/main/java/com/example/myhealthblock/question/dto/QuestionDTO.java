package com.example.myhealthblock.question.dto;

import com.example.myhealthblock.question.BodyPart;
import com.example.myhealthblock.question.Category;
import com.example.myhealthblock.question.PersonalData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDTO {
    Integer id;
    String uid;
    String title;
    Category category;
    String symptom;
    String content;
    List<BodyPart> bodyParts;
    PersonalData personalData;

}
