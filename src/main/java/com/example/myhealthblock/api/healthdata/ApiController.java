package com.example.myhealthblock.api.healthdata;

import com.example.myhealthblock.api.healthdata.dto.request.*;
import com.example.myhealthblock.api.healthdata.dto.response.HealthCheckupResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.MedicalHistoryResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.TreatmentInfoResponseDTO;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private int savedJobIndex;
    private int savedThreadIndex;


    @PostMapping("/v1/medical-api/medical-history/first-request")
    public ResponseEntity<String> requestMedicalHistory(@RequestBody MedicalHistoryFirstRequestDTO body) {
        try {
            String response = apiService.requestMedicalHistory(body);
            savedJti = extractJtiFromResponse(response);
            savedTwoWayTimestamp = extractTwoWayTimestampFromResponse(response);
            savedJobIndex = extractJobIndexFromResponse(response);
            savedThreadIndex = extractThreadIndexFromResponse(response);

            System.out.println(response);
            System.out.println("medical api 1차 호출");
            return new ResponseEntity<>("medical api 1차 인증 요청", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("500 Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/v1/medical-api/treatment-information/first-request")
    public ResponseEntity<String> requestTreatmentInformation(@RequestBody TreatmentInfoFirstRequestDTO body) {
        try {
            String response = apiService.requestTreatmentInformation(body);
            savedJti = extractJtiFromResponse(response);
            savedTwoWayTimestamp = extractTwoWayTimestampFromResponse(response);
            savedJobIndex = extractJobIndexFromResponse(response);
            savedThreadIndex = extractThreadIndexFromResponse(response);

            System.out.println(response);
            System.out.println("treatment api 1차 호출");
            return new ResponseEntity<>("treatment api 1차 인증 요청", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("500 Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/v1/medical-api/health-checkup-result/first-request")
    public ResponseEntity<String> requestHealthCheckupResult(@RequestBody HealthCheckupFirstRequestDTO body) {
        try {
            String response = apiService.requestHealthCheckupResult(body);
            savedJti = extractJtiFromResponse(response);
            savedTwoWayTimestamp = extractTwoWayTimestampFromResponse(response);
            savedJobIndex = extractJobIndexFromResponse(response);
            savedThreadIndex = extractThreadIndexFromResponse(response);

            System.out.println(response);
            System.out.println("healthCheckup api 1차 호출");
            return new ResponseEntity<>("healthCheckup api 1차 인증 요청", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("500 Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String extractJtiFromResponse(String result) {
        try {
            JSONObject json = new JSONObject(result);
            JSONObject data = json.getJSONObject("data");
            String jti = data.getString("jti");
            return (jti != null && !jti.isEmpty()) ? jti : "defaultJti";
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
            return (twoWayTimestamp > 0) ? twoWayTimestamp : 0L;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }
    private int extractJobIndexFromResponse(String result) {
        try {
            JSONObject json = new JSONObject(result);
            JSONObject data = json.getJSONObject("data");
            int jobIndex = data.getInt("jobIndex");
            return jobIndex;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }
    private int extractThreadIndexFromResponse(String result) {
        try {
            JSONObject json = new JSONObject(result);
            JSONObject data = json.getJSONObject("data");
            int threadIndex = data.getInt("threadIndex");
            return threadIndex;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @PostMapping("/v1/medical-api/medical-history/second-request")
    public ResponseEntity<MedicalHistoryResponseDTO> requestMedicalHistorySecond(@RequestBody MedicalHistorySecondRequestDTO body) {
        try {
            if (savedJti == null || savedTwoWayTimestamp == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            body.setJti(savedJti);
            body.setTwoWayTimestamp(savedTwoWayTimestamp);
            body.setJobIndex(savedJobIndex);
            body.setThreadIndex(savedThreadIndex);

            System.out.println("medical api 2차 호출");
            MedicalHistoryResponseDTO response = apiService.requestCertificationMedicalHistory(body);

            if ("CF-12003".equals(response.getResult().getCode())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/v1/medical-api/treatment-information/second-request")
    public ResponseEntity<TreatmentInfoResponseDTO> requestCertificationTreatmentInformation(@RequestBody TreatmentInfoSecondRequestDTO body) {
        try {
            if (savedJti == null || savedTwoWayTimestamp == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            body.setJti(savedJti);
            body.setTwoWayTimestamp(savedTwoWayTimestamp);
            body.setJobIndex(savedJobIndex);
            body.setThreadIndex(savedThreadIndex);

            System.out.println("treatment api 2차 호출");
            TreatmentInfoResponseDTO response = apiService.requestCertificationTreatmentInformation(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/v1/medical-api/health-checkup-result/second-request")
    public ResponseEntity<HealthCheckupResponseDTO> requestCertificationHealthCheckupResult(@RequestBody HealthCheckupSecondRequestDTO body) {
        try {
            if (savedJti == null || savedTwoWayTimestamp == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            body.setJti(savedJti);
            body.setTwoWayTimestamp(savedTwoWayTimestamp);
            body.setJobIndex(savedJobIndex);
            body.setThreadIndex(savedThreadIndex);

            System.out.println("healthCheckup api 2차 호출");
            HealthCheckupResponseDTO response = apiService.requestCertificationHealthCheckupResult(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
