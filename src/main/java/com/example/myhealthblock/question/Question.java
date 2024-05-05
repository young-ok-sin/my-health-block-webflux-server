package com.example.myhealthblock.question;

import com.example.myhealthblock.Patient.Patient;
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
