package com.example.myhealthblock.api.healthdata;

import java.util.HashMap;
import java.util.Map;

public interface ApiOutport {
    public String requestMedicalHistory(HashMap<String, Object> data);
    public String requestTreatmentInformation(HashMap<String, Object> data);
    public String requestHealthCheckupResult(HashMap<String, Object> data);
    public Map<String, Object> requestMedicalHistorySecond(HashMap<String, Object> data);
    public Map<String, Object> requestTreatmentInformationSecond(HashMap<String, Object> data);
    public Map<String, Object> requestHealthCheckupResultSecond(HashMap<String, Object> data);
}
