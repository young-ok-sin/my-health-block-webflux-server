package com.example.myhealthblock.opinion;

import com.example.myhealthblock.opinion.adapter.out.OpinionAdapter;
import com.example.myhealthblock.opinion.dto.OpinionEnrollDTO;
import com.example.myhealthblock.question.QuestionService;
import com.example.myhealthblock.question.dto.QuestionEntityDTO;
import com.example.myhealthblock.user.UserService;
import com.example.myhealthblock.user.dto.UserEntityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OpinionService {
    private final OpinionAdapter outport;
    private final QuestionService questionInport;
    private final UserService userInport;
    //    private final GetQuestionEntityDTO questionInport; DI 컨테이너 학습 후 적용
    //    private final GetUserEntityDTO userInport; DI 컨테이너 학습 후 적용

    public String enroll(OpinionEnrollDTO dto) {
        QuestionEntityDTO questionDto = questionInport.getQuestionEntityDTO(dto.getQuestionId());
        UserEntityDTO userDto = userInport.getUserEntityDTO(dto.getUserId());
        boolean result = outport.create(questionDto.getEntity(), userDto.getEntity(), dto.getContent());

        return result ? "success" : "fail";
    }
}
