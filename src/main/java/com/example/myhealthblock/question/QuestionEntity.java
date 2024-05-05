package com.example.myhealthblock.question;

import com.example.myhealthblock.Patient.PatientEntity;
import com.example.myhealthblock.opinion.OpinionEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "Question")
@NoArgsConstructor
public class QuestionEntity {
    public QuestionEntity(String userId, String title, Category category, String symptom, String content){
        this.patient = new PatientEntity(userId);
        this.title = title;
        this.category = category;
        this.symptom = symptom;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    private String title;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String symptom;
    private String content;
    @CreatedDate
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BodyPartMappingEntity> bodyPartMappings = new ArrayList<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OpinionEntity> opinions = new ArrayList<>();

    public QuestionEntity(int questionId) {
        this.id = questionId;
    }

    public void addBodyPartMapping(BodyPartMappingEntity bodyPartMapping) {
        bodyPartMappings.add(bodyPartMapping);
        bodyPartMapping.setQuestion(this);
    }
    public void removeBodyPartMapping(BodyPartMappingEntity bodyPartMapping) {
        bodyPartMappings.remove(bodyPartMapping);
        bodyPartMapping.setQuestion(null);
    }
}
