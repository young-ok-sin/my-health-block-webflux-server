package com.example.myhealthblock.question.personaldata;

import com.example.myhealthblock.question.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDataRepository  extends JpaRepository<PersonalDataEntity, Integer> {
    PersonalDataEntity findByQuestion(QuestionEntity question);
}
