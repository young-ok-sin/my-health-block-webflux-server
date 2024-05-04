package com.example.myhealthblock.question;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bodypartMapping")
@NoArgsConstructor
public class BodyPartMappingEntity {
    public BodyPartMappingEntity(Integer questionId, BodyPart bodyPart){
        this.question = new QuestionEntity(id);
        this.bodyPart = bodyPart;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    @Enumerated(EnumType.STRING)
    private BodyPart bodyPart;

    public BodyPartMappingEntity(QuestionEntity question, BodyPart bodyPart) {
        this.question = question;
        this.bodyPart = bodyPart;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

}
