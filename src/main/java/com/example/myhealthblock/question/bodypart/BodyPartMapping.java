package com.example.myhealthblock.question.bodypart;

import com.example.myhealthblock.question.QuestionEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyPartMapping {
    QuestionEntity question;
    BodyPart bodyPart;
}
