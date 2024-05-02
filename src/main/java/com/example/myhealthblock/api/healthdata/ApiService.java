package com.example.myhealthblock.api.healthdata;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ApiService {
    private final ApiOutport apiOutport = new ApiAdapter();

    public String requestMedicalHistory() {
        return apiOutport.requestMedicalHistory();
    }

    public String requestTreatmentImformation() {
        return apiOutport.requestTreatmentImformation();
    }

    public String requestHealthCheckupResult() {
        return apiOutport.requestHealthCheckupResult();
    }

    public String requestSecond() {
        return apiOutport.requestSecond();
    }
}
