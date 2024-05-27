package com.example.myhealthblock.api.healthdata;

import com.example.myhealthblock.api.healthdata.dto.response.HealthCheckupResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.TreatmentInfoResponseDTO;

import java.util.HashMap;

public interface ApiOutport {
    String requestMedicalHistory(HashMap<String, Object> data);
    String requestTreatmentInformation(HashMap<String, Object> data);
    String requestHealthCheckupResult(HashMap<String, Object> data);
//    public Map<String, Object> requestMedicalHistorySecond(HashMap<String, Object> data);
    TreatmentInfoResponseDTO requestCertificationTreatmentInformation(HashMap<String, Object> parameterMap);
    HealthCheckupResponseDTO requestCertificationHealthCheckupResult(HashMap<String, Object> parameterMap);
}
