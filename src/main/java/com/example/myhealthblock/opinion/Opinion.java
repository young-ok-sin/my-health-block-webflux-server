package com.example.myhealthblock.opinion;

import com.example.myhealthblock.question.Question;
import com.example.myhealthblock.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Opinion {
    int id;
    User user;
    String content;
    Question question;
}
