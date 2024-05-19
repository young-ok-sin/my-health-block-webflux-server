package com.example.myhealthblock.opinion.adapter.out;

import com.example.myhealthblock.question.adapter.out.QuestionEntity;
import com.example.myhealthblock.user.adapter.out.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@Entity(name = "opinion")
@NoArgsConstructor
public class OpinionEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity user;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    @CreatedDate
    private Date createDate;

}
