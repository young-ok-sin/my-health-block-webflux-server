package com.example.myhealthblock.patient.adapter.out;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.patient.PatientOutport;
import com.example.myhealthblock.patient.dto.PatientEntityDTO;
import com.example.myhealthblock.patient.dto.PatientUrgentDataViewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@LogExecutionTime(logTarget = LogTarget.ADAPTER)
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
    public String getUrgentData(String patientId, String reason, String doctorId) {
        String data = getUrgentData(patientId);
        UrgentDataSearchHistoryEntity history = new UrgentDataSearchHistoryEntity();
        history.setDoctorId(doctorId);
        history.setPatientId(patientId);
        history.setContent(data);
        history.setReason(reason);
        urgentDataSearchHistoryRepository.save(history);

        return data;
    }

    @Override
    public boolean deleteUrgentData(String patientId) {
        return enrollUrgentData(patientId, "");
    }

    @Override
    public PatientUrgentDataViewDTO[] getViewHistory(String patientId) {
        List<UrgentDataSearchHistoryEntity> historyList = this.urgentDataSearchHistoryRepository.findAllByPatientId(patientId);
        PatientUrgentDataViewDTO[] viewArray = new PatientUrgentDataViewDTO[historyList.size()];
        for (int i = 0; i < historyList.size(); i++) {
            UrgentDataSearchHistoryEntity history = historyList.get(i);
            viewArray[i] = new PatientUrgentDataViewDTO(
                    history.getDoctorId(),
                    history.getReason(),
                    history.getDate(),
                    history.getContent()
            );
        }
        return viewArray;
    }

    private PatientEntity getPatientEntity(String id) {
        return this.patientRepository.findByUserId(id);
    }
}
