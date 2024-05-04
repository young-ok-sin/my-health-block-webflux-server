package com.example.myhealthblock.question;

import com.example.myhealthblock.Patient.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {

    List<QuestionEntity> findByPatient(PatientEntity patient);
}
