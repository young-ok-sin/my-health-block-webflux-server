package com.example.myhealthblock.question;

import com.example.myhealthblock.patient.Patient;
import com.example.myhealthblock.question.adapter.out.bodypart.BodyPartMapping;
import com.example.myhealthblock.question.adapter.out.personaldata.PersonalData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
    Integer id;
    Patient patient;
    String title;
    String symptom;
    String content;
    BodyPartMapping bodyPartMapping;
    PersonalData personalData;
}
