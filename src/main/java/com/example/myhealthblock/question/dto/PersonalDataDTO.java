package com.example.myhealthblock.question.dto;

import com.example.myhealthblock.question.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDataDTO {
    int age;
    Gender gender;
    String disease;
    String medication;
}
