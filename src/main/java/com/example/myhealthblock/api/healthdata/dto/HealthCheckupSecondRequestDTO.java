package com.example.myhealthblock.api.healthdata.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
@AllArgsConstructor
@Getter
@Setter
public class HealthCheckupSecondRequestDTO {
    private String organization;
    private String loginType;
    private String identity;
    private String userName;
    private String loginTypeLevel;
    private String phoneNo;
    private String id;
    private String inquiryType;
    private String type;
    private String telecom;

    private String simpleAuth;
    private boolean is2Way;
    private int jobIndex;
    private int threadIndex;
    private String jti;
    private Long twoWayTimestamp;
    public HashMap<String, Object> getHashMap() {
        HashMap<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("organization", organization);
        parameterMap.put("loginType", loginType);
        parameterMap.put("loginTypeLevel", loginTypeLevel);
        parameterMap.put("userName", userName);
        parameterMap.put("phoneNo", phoneNo);
        parameterMap.put("id", id);
        parameterMap.put("identity", identity);
        parameterMap.put("inquiryType", inquiryType);
        parameterMap.put("type", type);
        parameterMap.put("telecom",  telecom);

        parameterMap.put("simpleAuth", simpleAuth);
        parameterMap.put("is2Way", is2Way);

        HashMap<String, Object> twoWayInfo = new HashMap<String, Object>();
        twoWayInfo.put("jobIndex", jobIndex);
        twoWayInfo.put("threadIndex", threadIndex);
        twoWayInfo.put("jti", jti);
        twoWayInfo.put("twoWayTimestamp", twoWayTimestamp);
        parameterMap.put("twoWayInfo", twoWayInfo);

        return parameterMap;
    }
}
