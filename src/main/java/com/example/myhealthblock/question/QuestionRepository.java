package com.example.myhealthblock.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {

    List<QuestionEntity> findByUserId(String uid);
}
