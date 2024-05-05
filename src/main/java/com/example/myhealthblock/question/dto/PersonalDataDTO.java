package com.example.myhealthblock.question.dto;

import com.example.myhealthblock.question.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonalDataDTO {
    int questionId;
    int age;
    Gender gender;
    String disease;
    String medication;
}
