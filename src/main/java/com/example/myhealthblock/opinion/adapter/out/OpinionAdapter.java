package com.example.myhealthblock.opinion.adapter.out;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.opinion.OpinionOutport;
import com.example.myhealthblock.opinion.dto.OpinionDTO;
import com.example.myhealthblock.question.adapter.out.QuestionEntity;
import com.example.myhealthblock.user.adapter.out.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@LogExecutionTime(logTarget = LogTarget.ADAPTER)
@RequiredArgsConstructor
@Service
public class OpinionAdapter implements OpinionOutport {
    private final OpinionRepository opinionRepository;

    @Override
    public boolean create(QuestionEntity question, UserEntity user, String content) {
        OpinionEntity opinion = new OpinionEntity();
        opinion.setContent(content);
        opinion.setUser(user);
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
        return getOpinionDTOs(opinionRepository.findAll());
    }

    @Override
    public OpinionDTO[] getMyOpinions(UserEntity user) {
        return getOpinionDTOs(opinionRepository.findByUser(user));
    }

    private OpinionDTO[] getOpinionDTOs(List<OpinionEntity> opinions) {
        return opinions.stream()
                .map(this::mapToDTO)
                .toArray(OpinionDTO[]::new);
    }

    private OpinionDTO mapToDTO(OpinionEntity opinion) {
        int id = opinion.getId();
        UserEntity user = opinion.getUser();
        String content = opinion.getContent();
        QuestionEntity question = opinion.getQuestion();

        return new OpinionDTO(id, user, content, question);
    }
}