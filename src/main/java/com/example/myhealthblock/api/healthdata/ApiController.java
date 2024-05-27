package com.example.myhealthblock.api.healthdata;

import com.example.myhealthblock.api.healthdata.dto.request.*;
import com.example.myhealthblock.api.healthdata.dto.response.HealthCheckupResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.TreatmentInfoResponseDTO;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {
    private final ApiService apiService;
    private String savedJti;
    private Long savedTwoWayTimestamp;
    @PostMapping("/v1/medical-api/medical-history/first-request")
    public String requestMedicalHistory(@RequestBody MedicalHistoryFirstRequestDTO body) {
        String response = apiService.requestMedicalHistory(body);

        savedJti = extractJtiFromResponse(response);
        savedTwoWayTimestamp = extractTwoWayTimestampFromResponse(response);

        System.out.println(response);

        return "a";
    }

    @PostMapping("/v1/medical-api/treatment-information/first-request")
    public String requestTreatmentInformation(@RequestBody TreatmentInfoFirstRequestDTO body) {
        String response = apiService.requestTreatmentInformation(body);

        savedJti = extractJtiFromResponse(response);
        savedTwoWayTimestamp = extractTwoWayTimestampFromResponse(response);

        System.out.println(response);

        return "a";
    }

    @PostMapping("/v1/medical-api/health-checkup-result/first-request")
    public String requestHealthCheckupResult(@RequestBody HealthCheckupFirstRequestDTO body) {
        String response = apiService.requestHealthCheckupResult(body);

        savedJti = extractJtiFromResponse(response);
        savedTwoWayTimestamp = extractTwoWayTimestampFromResponse(response);

        System.out.println(response);

        return "a";
    }
    private String extractJtiFromResponse(String result) {
        try {
            JSONObject json = new JSONObject(result);
            JSONObject data = json.getJSONObject("data");
            String jti = data.getString("jti");

            if (jti != null && !jti.isEmpty()) {
                return jti;
            } else {
                return "defaultJti";
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return "defaultJti";
        }
    }
    private Long extractTwoWayTimestampFromResponse(String result) {
        try {
            JSONObject json = new JSONObject(result);
            JSONObject data = json.getJSONObject("data");
            Long twoWayTimestamp = data.getLong("twoWayTimestamp");

            if (twoWayTimestamp > 0) {
                return twoWayTimestamp;
            } else {
                return 0L;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

//    @PostMapping("/v1/medical-api/medical-history/second-request")
//    public Map<String, Object> requestMedicalHistorySecond(@RequestBody MedicalHistorySecondRequestDTO body) {
//        if (savedJti != null && savedTwoWayTimestamp != null && savedTwoWayTimestamp > 0) {
//            body.setJti(savedJti);
//            body.setTwoWayTimestamp(savedTwoWayTimestamp);
//        } else {
//            System.out.println("Invalid JTI or TwoWayTimestamp");
//        }
//
//        Map<String, Object> response = apiService.requestMedicalHistorySecond(body);
//        System.out.println(apiService.requestMedicalHistorySecond(body));
//
//        return response;
//    }
    @PostMapping("/v1/medical-api/treatment-information/second-request")
    public TreatmentInfoResponseDTO requestCertificationTreatmentInformation(@RequestBody TreatmentInfoSecondRequestDTO body) {
        body.setJti(savedJti);
        body.setTwoWayTimestamp(savedTwoWayTimestamp);

        return apiService.requestCertificationTreatmentInformation(body);
    }

    @PostMapping("/v1/medical-api/health-checkup-result/second-request")
    public HealthCheckupResponseDTO requestCertificationHealthCheckupResult(@RequestBody HealthCheckupSecondRequestDTO body) {
        body.setJti(savedJti);
        body.setTwoWayTimestamp(savedTwoWayTimestamp);

        return apiService.requestCertificationHealthCheckupResult(body);
    }

}
