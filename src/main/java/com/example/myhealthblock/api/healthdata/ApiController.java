package com.example.myhealthblock.api.healthdata;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.myhealthblock.api.healthdata.dto.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {
//    private final ApiService apiService;
    @PostMapping("/v1/medical-api/medical-history/first-request")
    public String requestMedicalHistory(@RequestBody MedicalHistoryFirstRequestDTO request) {
        System.out.println("request.toString() = " + request.toString());
        return "a";
    }

    @PostMapping("/v1/medical-api/treatment-imformation/first-request")
    public String requestTreatmentImformation(@RequestBody TreatmentInfoFirstRequestDTO request) {
        System.out.println("request.toString() = " + request.toString());

        return "a";
    }

    @PostMapping("/v1/medical-api/health-checkup-result/first-request")
    public String requestHealthCheckupResult(@RequestBody HealthCheckupFirstRequestDTO request) {
        System.out.println("request.toString() = " + request.toString());

        return "a";
    }

    @PostMapping("/v1/medical-api/second-request")
    public String requestSecond(@RequestBody SecondRequestDTO request) {
        System.out.println("request.toString() = " + request.toString());

        return "a";
    }
}
