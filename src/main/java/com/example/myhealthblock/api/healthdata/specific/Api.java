package com.example.myhealthblock.api.healthdata.specific;

import java.util.HashMap;

public interface  Api {
    public String requestProductMedicalHistory(HashMap<String, Object> data);
    public String requestProductTreatmentInformation(HashMap<String, Object> data);
    public String requestHealthCheckupResult(HashMap<String, Object> data);

    public String requestCertificationMedicalHistory(HashMap<String, Object> parameterMap);
    public String requestCertificationTreatmentInformation(HashMap<String, Object> parameterMap);
    public String requestCertificationHealthCheckupResult(HashMap<String, Object> parameterMap);
}
