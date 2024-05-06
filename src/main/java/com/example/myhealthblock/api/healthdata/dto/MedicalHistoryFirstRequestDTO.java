package com.example.myhealthblock.api.healthdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
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

    public HashMap<String, Object> getHashMap() {
        HashMap<String, Object> parameterMap = new HashMap<String, Object>();

        parameterMap.put("organization", organization);
        parameterMap.put("loginType", loginType);
        parameterMap.put("identity", identity);
        parameterMap.put("userName", userName);
        parameterMap.put("loginTypeLevel", loginTypeLevel);
        parameterMap.put("phoneNo", phoneNo);
        parameterMap.put("statDate", startDate);
        parameterMap.put("endDate", endDate);
        parameterMap.put("telecom", telecom);

        return parameterMap;
    }
}
