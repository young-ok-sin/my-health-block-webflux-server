package com.example.myhealthblock.doctor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RequestPatientUrgentDataDTO {
    String patientId;
    String reason;
    String doctorId;
}
