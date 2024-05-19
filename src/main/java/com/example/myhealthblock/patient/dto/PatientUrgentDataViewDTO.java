package com.example.myhealthblock.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientUrgentDataViewDTO {
    private String doctorId;
    private String reason;
    private LocalDateTime date;
    private String content;
}
