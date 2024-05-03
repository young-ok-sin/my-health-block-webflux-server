package com.example.myhealthblock.question;

import com.example.myhealthblock.Patient.PatientEntity;
import com.example.myhealthblock.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Question")
@NoArgsConstructor
public class QuestionEntity {
    public QuestionEntity(String uid, String title, Category category, String symptom, String content){
        this.userId= uid;
        this.title = title;
        this.category = category;
        this.symptom = symptom;
        this.content = content;

        createDate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
    private String userId;

    private String title;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String symptom;
    private String content;

    private LocalDateTime createDate;
}
