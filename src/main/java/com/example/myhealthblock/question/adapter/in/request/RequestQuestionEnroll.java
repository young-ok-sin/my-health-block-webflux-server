package com.example.myhealthblock.question.adapter.in.request;

import com.example.myhealthblock.question.adapter.out.bodypart.BodyPart;
import com.example.myhealthblock.question.Category;
import com.example.myhealthblock.question.dto.PersonalDataDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestQuestionEnroll {
    String userId;
    List<BodyPart> bodyParts;
    Category category;
    String title;
    String symptom;
    String content;
    PersonalDataDTO personalData;
}
