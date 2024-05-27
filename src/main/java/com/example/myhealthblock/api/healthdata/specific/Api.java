package com.example.myhealthblock.api.healthdata.specific;

import com.example.myhealthblock.api.healthdata.dto.response.HealthCheckupResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.TreatmentInfoResponseDTO;

import java.util.HashMap;

public interface  Api {
    public String requestProductMedicalHistory(HashMap<String, Object> data);
    public String requestProductTreatmentInformation(HashMap<String, Object> data);
    public String requestHealthCheckupResult(HashMap<String, Object> data);

//    public Map<String, Object> requestCertificationMedicalHistory(HashMap<String, Object> parameterMap);
    TreatmentInfoResponseDTO requestCertificationTreatmentInformation(HashMap<String, Object> parameterMap);
    HealthCheckupResponseDTO requestCertificationHealthCheckupResult(HashMap<String, Object> parameterMap);

}
