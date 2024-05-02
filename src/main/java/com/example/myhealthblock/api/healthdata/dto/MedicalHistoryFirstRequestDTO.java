package com.example.myhealthblock.api.healthdata.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Getter
@Setter
public class MedicalHistoryFirstRequestDTO {
    private String organization;
    private String loginType;
    private String identity;
    private String userName;
    private String loginTypeLevel;
    private String phoneNo;
    private String startDate;
    private String endDate;
    private String telecom;
}
