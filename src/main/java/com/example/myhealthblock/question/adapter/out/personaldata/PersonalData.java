package com.example.myhealthblock.question.adapter.out.personaldata;

import com.example.myhealthblock.question.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalData {
    int age;
    Gender gender;
    String disease;
    String medication;
}
