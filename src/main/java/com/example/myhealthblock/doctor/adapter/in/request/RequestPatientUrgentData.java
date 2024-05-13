package com.example.myhealthblock.doctor.adapter.in.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RequestPatientUrgentData {
    String patientId;
    String reason;
    String doctorId;
}
