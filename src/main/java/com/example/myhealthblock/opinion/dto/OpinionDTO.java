package com.example.myhealthblock.opinion.dto;

import com.example.myhealthblock.question.QuestionEntity;
import com.example.myhealthblock.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpinionDTO {
    int id;
    UserEntity user;
    String content;
    QuestionEntity question;
}
