package com.example.myhealthblock.api.healthdata.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@AllArgsConstructor
@Getter
@Setter
public class TreatmentInfoSecondRequestDTO {
    private String simpleAuth;
    private boolean is2Way;
    private int jobIndex;
    private int threadIndex;
    private String jti;
    private Long twoWayTimestamp;

    private String organization;
    private String loginType;
    private String userName;
    private String identity;
    private String loginTypeLevel;
    private String phoneNo;
    private String timeOut;
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
        parameterMap.put("drugImageYN", drugImageYN);
        parameterMap.put("medicationDirectionYN", medicationDirectionYN);
        parameterMap.put("telecom", telecom);
        parameterMap.put("simpleAuth", "1");
        parameterMap.put("is2Way", true);

        HashMap<String, Object> twoWayInfo = new HashMap<String, Object>();
        twoWayInfo.put("jobIndex", 0);
        twoWayInfo.put("threadIndex", 0);
        twoWayInfo.put("jti", jti);
        twoWayInfo.put("twoWayTimestamp", twoWayTimestamp);
        parameterMap.put("twoWayInfo", twoWayInfo);

        return parameterMap;
    }
}
