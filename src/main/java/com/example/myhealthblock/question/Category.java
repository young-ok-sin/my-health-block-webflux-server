package com.example.myhealthblock.question;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    ENTIRE("전체 게시판"),
    MATERNITY("임산부 게시판"),
    ElDERS("노약자 게시판");

    private final String text;
}
