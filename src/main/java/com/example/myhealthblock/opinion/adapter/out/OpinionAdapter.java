package com.example.myhealthblock.opinion.adapter.out;

import com.example.myhealthblock.opinion.OpinionOutport;
import com.example.myhealthblock.opinion.dto.OpinionDTO;
import com.example.myhealthblock.question.adapter.out.QuestionEntity;
import com.example.myhealthblock.user.adapter.out.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class OpinionAdapter implements OpinionOutport {
    private final OpinionRepository opinionRepository;

    @Override
    public boolean create(int questionId, UserEntity user, String content) {
        QuestionEntity question = new QuestionEntity(questionId);
        OpinionEntity opinion = new OpinionEntity();
        opinion.setUser(user);
        opinion.setContent(content);
        opinion.setQuestion(question);
        opinionRepository.save(opinion);
        return true;
    }

    @Override
    public OpinionDTO getOpinion(int id) {
        OpinionEntity opinion = opinionRepository.findById(id).orElse(null);
        if (opinion == null) {
            return null;
        }
        return mapToDTO(opinion);
    }

    @Override
    public boolean delete(int id) {
        OpinionEntity opinion = opinionRepository.findById(id).orElse(null);
        if (opinion == null) {
            return false;
        }
        opinionRepository.delete(opinion);
        return true;
    }

    @Override
    public OpinionDTO[] getOpinions() {
        List<OpinionEntity> opinions = opinionRepository.findAll();
        return opinions.stream()
                .map(this::mapToDTO)
                .toArray(OpinionDTO[]::new);
    }

    @Override
    public OpinionDTO[] getMyOpinions(UserEntity user) {
        List<OpinionEntity> opinions = opinionRepository.findByUser(user);
        return opinions.stream()
                .map(this::mapToDTO)
                .toArray(OpinionDTO[]::new);
    }

    private OpinionDTO mapToDTO(OpinionEntity opinion) {
        UserEntity user = opinion.getUser();
        QuestionEntity question = opinion.getQuestion();
        return new OpinionDTO(
                opinion.getId(),
                user,
                opinion.getContent(),
                question
        );
    }
}