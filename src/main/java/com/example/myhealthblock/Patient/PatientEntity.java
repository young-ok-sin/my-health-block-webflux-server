package com.example.myhealthblock.patient;

import com.example.myhealthblock.question.QuestionEntity;
import com.example.myhealthblock.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "Patient")
@NoArgsConstructor
public class PatientEntity {
    public PatientEntity(String userId){
        this.userId = userId;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String userId;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionEntity> questions = new ArrayList<>();

    @Column
    private LocalDateTime createDate;

    @Column
    private LocalDateTime lastEditDate;

    public void addQuestion(QuestionEntity question) {
        questions.add(question);
        question.setPatient(this);
    }

    public void removeQuestion(QuestionEntity question) {
        questions.remove(question);
        question.setPatient(null);
    }

}
