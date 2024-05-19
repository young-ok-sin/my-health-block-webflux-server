package com.example.myhealthblock.patient;


import com.example.myhealthblock.patient.dto.PatientEntityDTO;
import com.example.myhealthblock.patient.dto.PatientUrgentDataViewDTO;

public interface PatientOutport {
    public boolean create(String id);
    public PatientEntityDTO getUserEntityDTO(String id);
    public boolean enrollUrgentData(String id, String content);
    public String getUrgentData(String id);
    public String getUrgentData(String id, String reason, String doctorId);
    public boolean deleteUrgentData(String patientId);
    public PatientUrgentDataViewDTO[] getViewHistory(String patientId);

}
