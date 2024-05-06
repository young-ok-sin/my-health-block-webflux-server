package com.example.myhealthblock.question;

import com.example.myhealthblock.patient.PatientEntity;
import com.example.myhealthblock.patient.PatientRepository;
import com.example.myhealthblock.question.bodypart.BodyMappingRepository;
import com.example.myhealthblock.question.bodypart.BodyPart;
import com.example.myhealthblock.question.bodypart.BodyPartMappingEntity;
import com.example.myhealthblock.question.dto.QuestionDTO;
import com.example.myhealthblock.question.personaldata.PersonalData;
import com.example.myhealthblock.question.personaldata.PersonalDataEntity;
import com.example.myhealthblock.question.personaldata.PersonalDataRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionAdapter implements QuestionOutport {
    private final QuestionRepository questionRepository;
    private final PatientRepository patientRepository;
    private final PersonalDataRepository personalDataRepository;
    private final BodyMappingRepository bodyMappingRepository;

    @Override
    public boolean create(PatientEntity patient, String title, Category category, String symptom, String content, List<BodyPart> bodyParts, PersonalData personalData) {
        QuestionEntity question = new QuestionEntity(patient, title, category, symptom, content);
        insertPatient(question, patient);
        insertBodyParts(question, bodyParts);
        insertPersonalData(question, personalData);
        questionRepository.save(question);

        return true;
    }

    @Override
    public QuestionDTO getQuestion(int id) {
        QuestionEntity questionEntity = getQuestionEntity(id);
        if (questionEntity == null) {
            return null;
        }

        return getQuestionDTO(questionEntity);
    }

    @Override
    public QuestionDTO[] getQuestions() {
        return getQuestionDTOs(this.questionRepository.findAll());
    }

    @Override
    public QuestionDTO[] getMyQuestions(PatientEntity patient) {
        return getQuestionDTOs(this.questionRepository.findByPatient(patient));
    }

    @Override
    public boolean delete(int id) {
        QuestionEntity questionEntity = getQuestionEntity(id);
        if (questionEntity == null) {
            return false;
        }

        deleteQuestion(questionEntity);
        return true;
    }

    private void insertPatient(QuestionEntity question, PatientEntity patient) {
        patient.addQuestion(question);
        patientRepository.save(patient);
    }

    private void insertBodyParts(QuestionEntity question, List<BodyPart> bodyParts) {
        for (BodyPart bodyPart : bodyParts) {
            bodyMappingRepository.save(new BodyPartMappingEntity(question, bodyPart));
        }
    }

    private void insertPersonalData(QuestionEntity question, PersonalData personalData) {
        if (personalData != null) {
            personalDataRepository.save(getPersonalDataEntity(question, personalData));
        }
    }

    private PersonalDataEntity getPersonalDataEntity(QuestionEntity question, PersonalData personalData) {
        PersonalDataEntity personalDataEntity = new PersonalDataEntity();
        personalDataEntity.setQuestion(question);
        personalDataEntity.setAge(personalData.getAge());
        personalDataEntity.setGender(personalData.getGender());
        personalDataEntity.setDisease(personalData.getDisease());
        personalDataEntity.setMedication(personalData.getMedication());

        return personalDataEntity;
    }

    private QuestionEntity getQuestionEntity(int id) {
        return this.questionRepository.findById(id).orElse(null);
    }

    private QuestionDTO[] getQuestionDTOs(List<QuestionEntity> questionEntities) {
        return questionEntities.stream()
                .map(this::getQuestionDTO)
                .toArray(QuestionDTO[]::new);
    }

    private QuestionDTO getQuestionDTO(QuestionEntity questionEntity) {
        PersonalData personalData = getPersonalData(personalDataRepository.findByQuestion(questionEntity));
        List<BodyPart> bodyParts = getBodyParts(questionEntity);

        return new QuestionDTO(
                questionEntity.getId(),
                questionEntity.getPatient().getUserId(),
                questionEntity.getTitle(),
                questionEntity.getCategory(),
                questionEntity.getSymptom(),
                questionEntity.getContent(),
                bodyParts,
                personalData
        );
    }

    private PersonalData getPersonalData(PersonalDataEntity personalDataEntity) {
        if (personalDataEntity == null) {
            return null;
        }

        PersonalData personalData = new PersonalData();

        personalData.setAge(personalDataEntity.getAge());
        personalData.setGender(personalDataEntity.getGender());
        personalData.setDisease(personalDataEntity.getDisease());
        personalData.setMedication(personalDataEntity.getMedication());

        return personalData;
    }

    private List<BodyPart> getBodyParts(QuestionEntity questionEntity) {
        return this.bodyMappingRepository.findByQuestion(questionEntity)
                .stream()
                .map(BodyPartMappingEntity::getBodyPart)
                .collect(Collectors.toList());
    }

    private void deleteQuestion(QuestionEntity questionEntity) {
        this.questionRepository.delete(questionEntity);
    }
}