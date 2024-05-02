package com.example.myhealthblock.api.healthdata;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class ApiService {
//    private final ApiOutport apiOutport;
    public String requestMedicalHistory() {
        return "requestMedicalHistory";
    }

    public String requestTreatmentImformation() {
        return "requestTreatmentImformation";
    }

    public String requestHealthCheckupResult() {
        return "requestHealthCheckupResult";
    }

    public String requestSecond() {
        return "requestSecond";
    }
}
