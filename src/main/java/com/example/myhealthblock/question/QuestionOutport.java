package com.example.myhealthblock.question;

import com.example.myhealthblock.patient.adapter.out.PatientEntity;
import com.example.myhealthblock.question.adapter.out.bodypart.BodyPart;
import com.example.myhealthblock.question.dto.QuestionDTO;
import com.example.myhealthblock.question.adapter.out.personaldata.PersonalData;
import com.example.myhealthblock.question.dto.QuestionEntityDTO;

import java.util.List;

public interface QuestionOutport {
    public boolean create(PatientEntity patient, String title, Category Category, String symptom, String content, List<BodyPart> bodyParts, PersonalData personalData);
    public QuestionDTO getQuestion(int id);

    public boolean delete(int id);
    public QuestionDTO[] getQuestions();

    public QuestionDTO[] getMyQuestions(PatientEntity patient);
    public QuestionEntityDTO getQuestionEntityDTO(int id);
}
