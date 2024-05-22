package com.example.myhealthblock.api.healthdata;

import com.example.myhealthblock.api.healthdata.dto.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class ApiService {
    private final ApiOutport apiOutport = new ApiAdapter();

    public String requestMedicalHistory(MedicalHistoryFirstRequestDTO dto) {
        return apiOutport.requestMedicalHistory(dto.getHashMap());
    }

    public String requestTreatmentInformation(TreatmentInfoFirstRequestDTO dto) {
        return apiOutport.requestTreatmentInformation(dto.getHashMap());
    }

    public String requestHealthCheckupResult(HealthCheckupFirstRequestDTO dto) {
        return apiOutport.requestHealthCheckupResult(dto.getHashMap());
    }

    public Map<String, Object> requestMedicalHistorySecond(MedicalHistorySecondRequestDTO dto) {
        return apiOutport.requestMedicalHistorySecond(dto.getHashMap());
    }

    public Map<String, Object> requestTreatmentInformationSecond(TreatmentInfoSecondRequestDTO dto) {
        return apiOutport.requestTreatmentInformationSecond(dto.getHashMap());
    }

    public Map<String, Object> requestHealthCheckupResultSecond(HealthCheckupSecondRequestDTO dto) {
        return apiOutport.requestHealthCheckupResultSecond(dto.getHashMap());
    }
}
