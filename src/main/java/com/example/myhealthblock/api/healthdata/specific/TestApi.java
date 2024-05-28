package com.example.myhealthblock.api.healthdata.specific;

import com.example.myhealthblock.api.healthdata.dto.response.HealthCheckupResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.MedicalHistoryResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.TreatmentInfoResponseDTO;

import java.util.HashMap;

public class TestApi implements Api{
    @Override
    public String requestProductMedicalHistory(HashMap<String, Object> data) {
        return "requestProductMedicalHistory test api";
    }

    @Override
    public String requestProductTreatmentInformation(HashMap<String, Object> data) {
        return "requestProductTreatmentInformation test api";
    }

    @Override
    public String requestHealthCheckupResult(HashMap<String, Object> data) {
        return "requestHealthCheckupResult test api";
    }

    @Override
    public MedicalHistoryResponseDTO requestCertificationMedicalHistory(HashMap<String, Object> parameterMap) {
        MedicalHistoryResponseDTO medicalHistoryResponseDTO = new MedicalHistoryResponseDTO();
        return medicalHistoryResponseDTO;
    }

    @Override
    public TreatmentInfoResponseDTO requestCertificationTreatmentInformation(HashMap<String, Object> parameterMap) {
        TreatmentInfoResponseDTO treatmentInfoResponseDTO = new TreatmentInfoResponseDTO();
        return treatmentInfoResponseDTO;
    }

    @Override
    public HealthCheckupResponseDTO requestCertificationHealthCheckupResult(HashMap<String, Object> parameterMap) {
        HealthCheckupResponseDTO healthCheckupResponseDTO = new HealthCheckupResponseDTO();
        return healthCheckupResponseDTO;
    }
}
