package com.example.myhealthblock.api.healthdata.specific;

import java.util.HashMap;

public interface  Api {
    String requestProductMedicalHistory(HashMap<String, Object> data);
    String requestProductTreatmentInformation(HashMap<String, Object> data);
    String requestHealthCheckupResult(HashMap<String, Object> data);

    String requestCertificationMedicalHistory(HashMap<String, Object> parameterMap);
    String requestCertificationTreatmentInformation(HashMap<String, Object> parameterMap);
    String requestCertificationHealthCheckupResult(HashMap<String, Object> parameterMap);

}
