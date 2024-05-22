package com.example.myhealthblock.api.healthdata.specific;

import java.util.HashMap;
import java.util.Map;

public interface  Api {
    public String requestProductMedicalHistory(HashMap<String, Object> data);
    public String requestProductTreatmentInformation(HashMap<String, Object> data);
    public String requestHealthCheckupResult(HashMap<String, Object> data);

    public Map<String, Object> requestCertificationMedicalHistory(HashMap<String, Object> parameterMap);
    public Map<String, Object> requestCertificationTreatmentInformation(HashMap<String, Object> parameterMap);
    public Map<String, Object> requestCertificationHealthCheckupResult(HashMap<String, Object> parameterMap);
}
