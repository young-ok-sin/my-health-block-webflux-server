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
    private final ApiService apiService;
    @PostMapping("/v1/medical-api/medical-history/first-request")
    public String requestMedicalHistory(@RequestBody MedicalHistoryFirstRequestDTO body) {
        System.out.println(apiService.requestMedicalHistory(body));

        return "a";
    }

    @PostMapping("/v1/medical-api/treatment-imformation/first-request")
    public String requestTreatmentImformation(@RequestBody TreatmentInfoFirstRequestDTO body) {
        System.out.println(apiService.requestTreatmentImformation(body));

        return "a";
    }

    @PostMapping("/v1/medical-api/health-checkup-result/first-request")
    public String requestHealthCheckupResult(@RequestBody HealthCheckupFirstRequestDTO body) {
        System.out.println(apiService.requestHealthCheckupResult(body));

        return "a";
    }

    @PostMapping("/v1/medical-api/medical-history/second-request")
    public String requestMedicalHistorySecond(@RequestBody SecondRequestDTO body) {
        System.out.println(apiService.requestMedicalHistorySecond(body));

        return "a";
    }

    @PostMapping("/v1/medical-api/treatment-imformation/second-request")
    public String requestTreatmentImformationSecond(@RequestBody SecondRequestDTO body) {
        System.out.println(apiService.requestTreatmentImformationSecond(body));

        return "a";
    }

    @PostMapping("/v1/medical-api/health-checkup-result/second-request")
    public String requestHealthCheckupResultSecond(@RequestBody SecondRequestDTO body) {
        System.out.println(apiService.requestHealthCheckupResultSecond(body));

        return "a";
    }
}
