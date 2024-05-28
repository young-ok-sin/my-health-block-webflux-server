package com.example.myhealthblock.api.healthdata;

import java.util.HashMap;

import com.example.myhealthblock.api.healthdata.dto.response.HealthCheckupResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.MedicalHistoryResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.TreatmentInfoResponseDTO;
import com.example.myhealthblock.api.healthdata.specific.*;

public class ApiAdapter implements ApiOutport{

    private final Api api = new RealApi();
//    private final Api api = new TestApi();

    @Override
    public String requestMedicalHistory(HashMap<String, Object> data) {
        return api.requestProductMedicalHistory(data);
    }

    @Override
    public String requestTreatmentInformation(HashMap<String, Object> data) { return api.requestProductTreatmentInformation(data); }

    @Override
    public String requestHealthCheckupResult(HashMap<String, Object> data) { return api.requestHealthCheckupResult(data); }

    @Override
    public MedicalHistoryResponseDTO requestCertificationMedicalHistory(HashMap<String, Object> data) { return api.requestCertificationMedicalHistory(data); }
    @Override
    public TreatmentInfoResponseDTO<?> requestCertificationTreatmentInformation(HashMap<String, Object> data) {
        return api.requestCertificationTreatmentInformation(data);
    }

    @Override
    public HealthCheckupResponseDTO<?> requestCertificationHealthCheckupResult(HashMap<String, Object> data) {
        return api.requestCertificationHealthCheckupResult(data);
    }
}
