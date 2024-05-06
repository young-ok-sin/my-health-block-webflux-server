package com.example.myhealthblock.opinion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpinionEnrollDTO {
    String userId;
    String content;
    Integer questionId;
}
