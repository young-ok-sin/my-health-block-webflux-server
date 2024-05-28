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

    @PostMapping("/v1/medical-api/medical-history/first-request")
    public ResponseEntity<String> requestMedicalHistory(@RequestBody MedicalHistoryFirstRequestDTO body) {
        try {
            String response = apiService.requestMedicalHistory(body);
            savedJti = extractJtiFromResponse(response);
            savedTwoWayTimestamp = extractTwoWayTimestampFromResponse(response);
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
    @PostMapping("/v1/medical-api/medical-history/second-request")
    public ResponseEntity<MedicalHistoryResponseDTO> requestMedicalHistorySecond(@RequestBody MedicalHistorySecondRequestDTO body) {
        try {
            if (savedJti == null || savedTwoWayTimestamp == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            body.setJti(savedJti);
            body.setTwoWayTimestamp(savedTwoWayTimestamp);
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
            System.out.println("healthCheckup api 2차 호출");
            HealthCheckupResponseDTO response = apiService.requestCertificationHealthCheckupResult(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
//    }
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api")
//public class ApiController {
//    private final ApiService apiService;
//    private String savedJti;
//    private Long savedTwoWayTimestamp;
//    @PostMapping("/v1/medical-api/medical-history/first-request")
//    public String requestMedicalHistory(@RequestBody MedicalHistoryFirstRequestDTO body) {
//        String response = apiService.requestMedicalHistory(body);
//
//        savedJti = extractJtiFromResponse(response);
//        savedTwoWayTimestamp = extractTwoWayTimestampFromResponse(response);
//
//        System.out.println(response);
//        System.out.println("medical api 1차 호출");
//        return "medical api 1차 인증 요청";
//    }
//
//    @PostMapping("/v1/medical-api/treatment-information/first-request")
//    public String requestTreatmentInformation(@RequestBody TreatmentInfoFirstRequestDTO body) {
//        String response = apiService.requestTreatmentInformation(body);
//
//        savedJti = extractJtiFromResponse(response);
//        savedTwoWayTimestamp = extractTwoWayTimestampFromResponse(response);
//
//        System.out.println(response);
//        System.out.println("treatment api 1차 호출");
//        return "treatment api 1차 인증 요청";
//    }
//
//    @PostMapping("/v1/medical-api/health-checkup-result/first-request")
//    public String requestHealthCheckupResult(@RequestBody HealthCheckupFirstRequestDTO body) {
//        String response = apiService.requestHealthCheckupResult(body);
//
//        savedJti = extractJtiFromResponse(response);
//        savedTwoWayTimestamp = extractTwoWayTimestampFromResponse(response);
//
//        System.out.println(response);
//        System.out.println("healthCheckup api 1차 호출");
//        return "healthCheckup api 1차 인증 요청";
//    }
//    private String extractJtiFromResponse(String result) {
//        try {
//            JSONObject json = new JSONObject(result);
//            JSONObject data = json.getJSONObject("data");
//            String jti = data.getString("jti");
//
//            if (jti != null && !jti.isEmpty()) {
//                return jti;
//            } else {
//                return "defaultJti";
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//            return "defaultJti";
//        }
//    }
//    private Long extractTwoWayTimestampFromResponse(String result) {
//        try {
//            JSONObject json = new JSONObject(result);
//            JSONObject data = json.getJSONObject("data");
//            Long twoWayTimestamp = data.getLong("twoWayTimestamp");
//
//            if (twoWayTimestamp > 0) {
//                return twoWayTimestamp;
//            } else {
//                return 0L;
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//            return 0L;
//        }
//    }
//
//    @PostMapping("/v1/medical-api/medical-history/second-request")
//    public MedicalHistoryResponseDTO requestMedicalHistorySecond(@RequestBody MedicalHistorySecondRequestDTO body) {
//        body.setJti(savedJti);
//        body.setTwoWayTimestamp(savedTwoWayTimestamp);
//        System.out.println("medical api 2차 호출");
//        return apiService.requestCertificationMedicalHistory(body);
//    }
//    @PostMapping("/v1/medical-api/treatment-information/second-request")
//    public TreatmentInfoResponseDTO requestCertificationTreatmentInformation(@RequestBody TreatmentInfoSecondRequestDTO body) {
//        body.setJti(savedJti);
//        body.setTwoWayTimestamp(savedTwoWayTimestamp);
//        System.out.println("treatment api 2차 호출");
//        return apiService.requestCertificationTreatmentInformation(body);
//    }
//
//    @PostMapping("/v1/medical-api/health-checkup-result/second-request")
//    public HealthCheckupResponseDTO requestCertificationHealthCheckupResult(@RequestBody HealthCheckupSecondRequestDTO body) {
//        body.setJti(savedJti);
//        body.setTwoWayTimestamp(savedTwoWayTimestamp);
//        System.out.println("healthCheckup api 2차 호출");
//        return apiService.requestCertificationHealthCheckupResult(body);
//    }
//
//}
