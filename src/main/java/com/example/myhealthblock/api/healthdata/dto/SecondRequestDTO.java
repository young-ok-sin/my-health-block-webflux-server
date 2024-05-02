package com.example.myhealthblock.api.healthdata.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SecondRequestDTO {
    private String simpleAuth;
    private String is2Way;
    private String jobIndex;
    private String threadIndex;
    private String phoneNo;
    private String jti;
    private String twoWayTimestamp;
    private String twoWayInfo;
}
