package com.example.myhealthblock.question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDataRepository  extends JpaRepository<PersonalDataEntity, Integer> {
    PersonalDataEntity findByQuestion(QuestionEntity question);
}
