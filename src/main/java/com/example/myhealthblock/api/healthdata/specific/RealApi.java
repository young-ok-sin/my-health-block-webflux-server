package com.example.myhealthblock.api.healthdata.specific;

import com.example.myhealthblock.api.healthdata.dto.response.HealthCheckupResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.MedicalHistoryResponseDTO;
import com.example.myhealthblock.api.healthdata.dto.response.TreatmentInfoResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class RealApi implements Api{
    private static final String MEDICAL_HISTORY = "/v1/kr/public/pp/nhis-lifetime-health/treatment-contents";
    private static final String TREATMENT_INFORMATION = "/v1/kr/public/pp/nhis-treatment/information";
    private static final String HEALTH_CHECKUP_RESULT = "/v1/kr/public/pp/nhis-health-checkup/result";
    private EasyCodef codef;

    public RealApi() {
        codef = new EasyCodef();
        codef.setClientInfoForDemo(EasyCodefClientInfo.DEMO_CLIENT_ID, EasyCodefClientInfo.DEMO_CLIENT_SECRET);
        codef.setPublicKey(EasyCodefClientInfo.PUBLIC_KEY);
    }

    @Override
    public String requestProductMedicalHistory(HashMap<String, Object> data) {
        return requestProduct(MEDICAL_HISTORY, data);
    }

    @Override
    public String requestProductTreatmentInformation(HashMap<String, Object> data) {
        return requestProduct(TREATMENT_INFORMATION, data);
    }

    @Override
    public String requestHealthCheckupResult(HashMap<String, Object> data) {
        return requestProduct(HEALTH_CHECKUP_RESULT, data);
    }

    private String requestProduct(String url, HashMap<String, Object> data) {
        String result = "";

        try {
            result = codef.requestProduct(url, EasyCodefServiceType.DEMO, data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public MedicalHistoryResponseDTO requestCertificationMedicalHistory(HashMap<String, Object> parameterMap) {
        return requestCertification(MEDICAL_HISTORY, parameterMap, MedicalHistoryResponseDTO.class);
    }

    @Override
    public TreatmentInfoResponseDTO requestCertificationTreatmentInformation(HashMap<String, Object> parameterMap) {
        return requestCertification(TREATMENT_INFORMATION, parameterMap, TreatmentInfoResponseDTO.class);
    }

    @Override
    public HealthCheckupResponseDTO requestCertificationHealthCheckupResult(HashMap<String, Object> parameterMap) {
        return requestCertification(HEALTH_CHECKUP_RESULT, parameterMap, HealthCheckupResponseDTO.class);
    }

    private <T> T requestCertification(String url, HashMap<String, Object> data, Class<T> responseType) {
        String result = "";
        ObjectMapper objectMapper = new ObjectMapper();
        T responseDTO = null;
        try {
            result = codef.requestCertification(url, EasyCodefServiceType.DEMO, data);
            responseDTO = objectMapper.readValue(result, responseType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return responseDTO;
    }
}