package com.example.myhealthblock.question.adapter.in.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseResult {
    private String result;

    public ResponseResult(String result) {
        this.result = result;
    }
}
