package com.example.myhealthblock.patient.adapter.out;

import com.example.myhealthblock.patient.PatientOutport;
import com.example.myhealthblock.patient.dto.PatientEntityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PatientAdapter implements PatientOutport {
    private final PatientRepository patientRepository;
    private final UrgentDataSearchHistoryRepository urgentDataSearchHistoryRepository;

    @Override
    public boolean create(String id) {
        PatientEntity p = new PatientEntity(id);
        this.patientRepository.save(p);

        return true;
    }

    @Override
    public PatientEntityDTO getUserEntityDTO(String id) {
        return new PatientEntityDTO(getPatientEntity(id));
    }

    @Override
    public boolean enrollUrgentData(String id, String content) {
        PatientEntity patient = getPatientEntity(id);
        patient.setUrgentData(content);
        this.patientRepository.save(patient);
        return true;
    }

    @Override
    public String getUrgentData(String id) {
        return getPatientEntity(id).getUrgentData();
    }

    @Override
    public String getUrgentData(String id, String reason, String doctorId) {
        String data = getUrgentData(id);
        UrgentDataSearchHistoryEntity history = new UrgentDataSearchHistoryEntity();
        history.setDoctorId(doctorId);
        history.setContent(data);
        history.setReason(reason);
        history.setDoctorId(doctorId);
        urgentDataSearchHistoryRepository.save(history);

        return data;
    }

    private PatientEntity getPatientEntity(String id) {
        return this.patientRepository.findByUserId(id);
    }
}
