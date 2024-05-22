package com.example.myhealthblock.api.healthdata.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TreatmentInfoFirstRequestDTO {
    private String organization;
    private String loginType;
    private String identity;
    private String userName;
    private String loginTypeLevel;
    private String phoneNo;
    private String timeOut;
    private String type;
    private String drugImageYN;
    private String medicationDirectionYN;
    private String telecom;

    public HashMap<String, Object> getHashMap() {
        HashMap<String, Object> parameterMap = new HashMap<String, Object>();

        parameterMap.put("organization", organization);
        parameterMap.put("loginType", loginType);
        parameterMap.put("identity", identity);
        parameterMap.put("userName", userName);
        parameterMap.put("loginTypeLevel", loginTypeLevel);
        parameterMap.put("phoneNo", phoneNo);
        parameterMap.put("timeOut", timeOut);
        parameterMap.put("drugImageYN", drugImageYN);
        parameterMap.put("medicationDirectionYN", medicationDirectionYN);
        parameterMap.put("telecom", telecom);
        parameterMap.put("type", type);

        return parameterMap;
    }
}
