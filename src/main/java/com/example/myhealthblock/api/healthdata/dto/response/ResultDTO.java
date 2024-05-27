package com.example.myhealthblock.api.healthdata.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResultDTO {
    private String code;
    private String extraMessage;
    private String message;
    private String transactionId;
}
