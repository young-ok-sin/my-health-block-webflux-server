package com.example.myhealthblock.question;

import com.example.myhealthblock.Patient.PatientEntity;
import com.example.myhealthblock.Patient.PatientRepository;
import com.example.myhealthblock.question.dto.QuestionDTO;
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
        QuestionEntity question = new QuestionEntity(patient.getUserId(), title, category, symptom, content);
        patient.addQuestion(question);

        for (BodyPart bodyPart : bodyParts) {
            BodyPartMappingEntity bodyPartMapping = new BodyPartMappingEntity(question, bodyPart);
            bodyMappingRepository.save(bodyPartMapping);
        }

        PersonalDataEntity personalDataEntity = new PersonalDataEntity();
        personalDataEntity.setQuestion(question);
        personalDataEntity.setAge(personalData.getAge());
        personalDataEntity.setGender(personalData.getGender());
        personalDataEntity.setDisease(personalData.getDisease());
        personalDataEntity.setMedication(personalData.getMedication());
        personalDataRepository.save(personalDataEntity);

        patientRepository.save(patient);
        return true;
    }

    private PersonalData getPersonalData(QuestionEntity questionEntity) {
        PersonalDataEntity personalDataEntity = this.personalDataRepository.findByQuestion(questionEntity);
        if (personalDataEntity != null) {
            PersonalData personalData = new PersonalData();
            personalData.setAge(personalDataEntity.getAge());
            personalData.setGender(personalDataEntity.getGender());
            personalData.setDisease(personalDataEntity.getDisease());
            personalData.setMedication(personalDataEntity.getMedication());
            return personalData;
        }
        return null;
    }

    @Override
    public QuestionDTO getQuestion(int id) {
        QuestionEntity questionEntity = this.questionRepository.findById(id).orElse(null);
        if (questionEntity == null) {
            return null;
        }

        PersonalData personalData = getPersonalData(questionEntity);
        List<BodyPart> bodyParts = this.bodyMappingRepository.findByQuestion(questionEntity)
                .stream()
                .map(BodyPartMappingEntity::getBodyPart)
                .collect(Collectors.toList());

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

    @Override
    public boolean delete(int id) {
        QuestionEntity questionEntity = this.questionRepository.findById(id).orElse(null);
        if (questionEntity == null) {
            return false;
        }
        this.questionRepository.delete(questionEntity);
        return true;
    }

    @Override
    public QuestionDTO[] getQuestions() {
        List<QuestionEntity> questionEntities = this.questionRepository.findAll();
        return getQuestionDTOS(questionEntities);
    }

    private QuestionDTO[] getQuestionDTOS(List<QuestionEntity> questionEntities) {
        return questionEntities.stream()
                .map(q -> {
                    List<BodyPart> bodyParts = this.bodyMappingRepository.findByQuestion(q)
                            .stream()
                            .map(BodyPartMappingEntity::getBodyPart)
                            .collect(Collectors.toList());
                    return new QuestionDTO(
                            q.getId(),
                            q.getPatient().getUserId(),
                            q.getTitle(),
                            q.getCategory(),
                            q.getSymptom(),
                            q.getContent(),
                            bodyParts,
                            getPersonalData(q)
                    );
                })
                .toArray(QuestionDTO[]::new);
    }

    @Override
    public QuestionDTO[] getMyQuestions(PatientEntity patient) {
        List<QuestionEntity> questionEntities = this.questionRepository.findByPatient(patient);
        return getQuestionDTOS(questionEntities);
    }
}