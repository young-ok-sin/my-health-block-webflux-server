package com.example.myhealthblock.opinion;
import com.example.myhealthblock.opinion.dto.OpinionDTO;
import com.example.myhealthblock.user.UserEntity;

public interface OpinionOutport {

    public boolean create (int questionId, UserEntity user, String content);
    public OpinionDTO getOpinion(int id);
    public boolean delete(int id);
    public OpinionDTO[] getOpinions();
    public OpinionDTO[] getMyOpinions(UserEntity user);
}
