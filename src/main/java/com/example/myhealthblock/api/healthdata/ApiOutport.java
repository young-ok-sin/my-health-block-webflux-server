package com.example.myhealthblock.api.healthdata;

import java.util.HashMap;

public interface ApiOutport {
    public String requestMedicalHistory(HashMap<String, Object> data);
    public String requestTreatmentInformation(HashMap<String, Object> data);
    public String requestHealthCheckupResult(HashMap<String, Object> data);
    public String requestMedicalHistorySecond(HashMap<String, Object> data);
    public String requestTreatmentInformationSecond(HashMap<String, Object> data);
    public String requestHealthCheckupResultSecond(HashMap<String, Object> data);
}
