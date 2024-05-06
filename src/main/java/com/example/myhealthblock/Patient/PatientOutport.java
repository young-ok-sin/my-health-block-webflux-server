package com.example.myhealthblock.patient;


import com.example.myhealthblock.patient.dto.PatientEntityDTO;

public interface PatientOutport {
    public boolean create(String id);
    public PatientEntityDTO getUserEntityDTO(String id);
    public boolean enrollUrgentData(String id, String content);
    public String getUrgentData(String id, String reason, String doctorId);
}
