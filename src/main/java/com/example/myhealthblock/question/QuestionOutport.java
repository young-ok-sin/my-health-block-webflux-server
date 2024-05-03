package com.example.myhealthblock.question;

import com.example.myhealthblock.Patient.PatientEntity;
import com.example.myhealthblock.question.dto.QuestionDTO;

public interface QuestionOutport {
    public boolean create(String uid, String title, Category Category, String symptom, String content);
    public QuestionDTO getQuestion(int id);

    public boolean update(int id, String title, Category Category, String symptom, String content);

    public boolean delete(int id);
    public QuestionDTO[] getQuestions();

    public QuestionDTO[] getMyQuestions(String uid);
}
