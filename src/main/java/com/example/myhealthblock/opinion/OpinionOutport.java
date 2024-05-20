package com.example.myhealthblock.opinion;
import com.example.myhealthblock.opinion.dto.OpinionDTO;
import com.example.myhealthblock.question.adapter.out.QuestionEntity;
import com.example.myhealthblock.user.adapter.out.UserEntity;

public interface OpinionOutport {

    public boolean create (QuestionEntity question, UserEntity user, String content);
    public OpinionDTO[] getOpinions(UserEntity user);
    public OpinionDTO[] getOpinions(QuestionEntity question);
    public boolean delete(int id);
}
