package com.example.myhealthblock.patient.adapter.in.response;

import com.example.myhealthblock.patient.dto.PatientUrgentDataViewDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponsePatientUrgentDataViewHistory {
    private PatientUrgentDataViewDTO[] history;

    public ResponsePatientUrgentDataViewHistory(PatientUrgentDataViewDTO[] history) {
        this.history = history;
    }
}
