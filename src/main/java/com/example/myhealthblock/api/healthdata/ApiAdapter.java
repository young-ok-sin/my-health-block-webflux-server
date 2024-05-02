package com.example.myhealthblock.api.healthdata;

public class ApiAdapter implements ApiOutport{
    @Override
    public String requestMedicalHistory() {
        return "requestMedicalHistory";
    }

    @Override
    public String requestTreatmentImformation() {
        return "requestTreatmentImformation";
    }

    @Override
    public String requestHealthCheckupResult() {
        return "requestHealthCheckupResult";
    }

    @Override
    public String requestSecond() {
        return "requestSecond";
    }
}
