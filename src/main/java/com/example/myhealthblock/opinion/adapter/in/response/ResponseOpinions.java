package com.example.myhealthblock.opinion.adapter.in.response;

import com.example.myhealthblock.opinion.dto.OpinionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOpinions {
    private OpinionDTO[] opinions;
}
