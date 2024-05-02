package com.example.myhealthblock.api.healthdata;

import com.example.myhealthblock.api.healthdata.dto.HealthCheckupFirstRequestDTO;
import com.example.myhealthblock.api.healthdata.dto.MedicalHistoryFirstRequestDTO;
import com.example.myhealthblock.api.healthdata.dto.SecondRequestDTO;
import com.example.myhealthblock.api.healthdata.dto.TreatmentInfoFirstRequestDTO;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ApiService {
    private final ApiOutport apiOutport = new ApiAdapter();

    public String requestMedicalHistory(MedicalHistoryFirstRequestDTO dto) {
        return apiOutport.requestMedicalHistory(dto.getHashMap());
    }

    public String requestTreatmentImformation(TreatmentInfoFirstRequestDTO dto) {
        return apiOutport.requestTreatmentImformation(dto.getHashMap());
    }


    public String requestHealthCheckupResult(HealthCheckupFirstRequestDTO dto) {
        return apiOutport.requestHealthCheckupResult(dto.getHashMap());
    }

    public String requestMedicalHistorySecond(SecondRequestDTO dto) {
        return apiOutport.requestMedicalHistorySecond(dto.getHashMap());
    }

    public String requestTreatmentImformationSecond(SecondRequestDTO dto) {
        return apiOutport.requestTreatmentImformationSecond(dto.getHashMap());
    }

    public String requestHealthCheckupResultSecond(SecondRequestDTO dto) {
        return apiOutport.requestHealthCheckupResultSecond(dto.getHashMap());
    }
}
