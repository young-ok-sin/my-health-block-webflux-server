package com.example.myhealthblock.api.healthdata.specific;

import com.example.myhealthblock.api.healthdata.dto.response.HealthCheckupResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.MedicalHistoryResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.TreatmentInfoResponseDTO;

import java.util.HashMap;

public interface  Api {
    String requestProductMedicalHistory(HashMap<String, Object> data);
    String requestProductTreatmentInformation(HashMap<String, Object> data);
    String requestHealthCheckupResult(HashMap<String, Object> data);

    MedicalHistoryResponseDTO requestCertificationMedicalHistory(HashMap<String, Object> parameterMap);
    TreatmentInfoResponseDTO requestCertificationTreatmentInformation(HashMap<String, Object> parameterMap);
    HealthCheckupResponseDTO requestCertificationHealthCheckupResult(HashMap<String, Object> parameterMap);

}
