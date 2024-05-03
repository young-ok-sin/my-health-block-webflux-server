package com.example.myhealthblock.question;

import com.example.myhealthblock.question.dto.QuestionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionAdapter implements QuestionOutport{
    private final QuestionRepository questionRepository;

    @Override
    public boolean create(String uid, String title, Category category, String symptom, String content){
        QuestionEntity q = new QuestionEntity(uid,title,category,symptom,content);
        this.questionRepository.save(q);

        return true;
    }

    @Override
    public QuestionDTO getQuestion(int id) {
        QuestionEntity questionEntity = this.questionRepository.findById(id).orElse(null);
        if (questionEntity == null) {
            return null;
        }
        return new QuestionDTO(
                questionEntity.getId(),
                questionEntity.getUserId(),
                questionEntity.getTitle(),
                questionEntity.getCategory(),
                questionEntity.getSymptom(),
                questionEntity.getContent()
        );
    }

    @Override
    public boolean update(int id, String title, Category category, String symptom, String content) {
        QuestionEntity questionEntity = this.questionRepository.findById(id).orElse(null);
        if (questionEntity == null) {
            return false;
        }
        questionEntity.setTitle(title);
        questionEntity.setCategory(category);
        questionEntity.setSymptom(symptom);
        questionEntity.setContent(content);
        this.questionRepository.save(questionEntity);
        return true;
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
        return questionEntities.stream()
                .map(q -> new QuestionDTO(
                        q.getId(),
                        q.getUserId(),
                        q.getTitle(),
                        q.getCategory(),
                        q.getSymptom(),
                        q.getContent()
                ))
                .toArray(QuestionDTO[]::new);
    }

    @Override
    public QuestionDTO[] getMyQuestions(String uid) {
        List<QuestionEntity> questionEntities = this.questionRepository.findByUserId(uid);
        return questionEntities.stream()
                .map(q -> new QuestionDTO(
                        q.getId(),
                        q.getUserId(),
                        q.getTitle(),
                        q.getCategory(),
                        q.getSymptom(),
                        q.getContent()
                ))
                .toArray(QuestionDTO[]::new);
    }

}
