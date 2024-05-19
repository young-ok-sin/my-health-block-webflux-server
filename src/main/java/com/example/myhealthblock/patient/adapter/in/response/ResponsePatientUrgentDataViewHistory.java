package com.example.myhealthblock.patient.adapter.in.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponsePatientUrgentDataViewHistory {
    private PatientUrgentDataView[] history;

    @Getter
    @Setter
    public static class PatientUrgentDataView {
        private String doctorId;
        private String reason;
        private LocalDateTime date;
        private String content;
    }
}
