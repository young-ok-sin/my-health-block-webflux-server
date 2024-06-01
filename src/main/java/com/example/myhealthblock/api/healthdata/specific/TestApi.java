package com.example.myhealthblock.api.healthdata.specific;

import java.util.HashMap;

public class TestApi implements Api{
    @Override
    public String requestProductMedicalHistory(HashMap<String, Object> data) {
        return "requestProductMedicalHistory test api";
    }

    @Override
    public String requestProductTreatmentInformation(HashMap<String, Object> data) {
        return "requestProductTreatmentInformation test api";
    }

    @Override
    public String requestHealthCheckupResult(HashMap<String, Object> data) {
        return "requestHealthCheckupResult test api";
    }

    @Override
    public String requestCertificationMedicalHistory(HashMap<String, Object> parameterMap) {
        return "requestProductMedicalHistory test api";
    }

    @Override
    public String requestCertificationTreatmentInformation(HashMap<String, Object> parameterMap) {
        return "requestProductTreatmentInformation test api";
    }

    @Override
    public String requestCertificationHealthCheckupResult(HashMap<String, Object> parameterMap) {
        return "requestHealthCheckupResult test api";
    }
}
