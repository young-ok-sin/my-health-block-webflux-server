package com.example.myhealthblock.api.healthdata;

import java.util.HashMap;
import java.util.Map;

import com.example.myhealthblock.api.healthdata.specific.*;

public class ApiAdapter implements ApiOutport{

    private final Api api = new RealApi();
//    private final Api api = new TestApi();

    @Override
    public String requestMedicalHistory(HashMap<String, Object> data) {
        return api.requestProductMedicalHistory(data);
    }

    @Override
    public String requestTreatmentInformation(HashMap<String, Object> data) { return api.requestProductTreatmentInformation(data); }

    @Override
    public String requestHealthCheckupResult(HashMap<String, Object> data) { return api.requestHealthCheckupResult(data); }

    @Override
    public Map<String, Object> requestMedicalHistorySecond(HashMap<String, Object> data) { return api.requestCertificationMedicalHistory(data); }

    @Override
    public Map<String, Object> requestTreatmentInformationSecond(HashMap<String, Object> data) { return api.requestCertificationTreatmentInformation(data); }

    @Override
    public Map<String, Object> requestHealthCheckupResultSecond(HashMap<String, Object> data) { return api.requestCertificationHealthCheckupResult(data); }
}
