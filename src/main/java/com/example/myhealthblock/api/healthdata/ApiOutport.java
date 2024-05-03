package com.example.myhealthblock.api.healthdata;

import com.example.myhealthblock.api.healthdata.dto.HealthCheckupFirstRequestDTO;
import com.example.myhealthblock.api.healthdata.dto.MedicalHistoryFirstRequestDTO;
import com.example.myhealthblock.api.healthdata.dto.SecondRequestDTO;
import com.example.myhealthblock.api.healthdata.dto.TreatmentInfoFirstRequestDTO;

import java.util.HashMap;

public interface ApiOutport {
    public String requestMedicalHistory(HashMap<String, Object> data);
    public String requestTreatmentImformation(HashMap<String, Object> data);
    public String requestHealthCheckupResult(HashMap<String, Object> data);
    public String requestMedicalHistorySecond(HashMap<String, Object> data);
    public String requestTreatmentImformationSecond(HashMap<String, Object> data);
    public String requestHealthCheckupResultSecond(HashMap<String, Object> data);
}
