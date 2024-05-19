package com.example.myhealthblock.doctor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DoctorProfileDTO {
    private String name;
    private String field;
    private String hospital;
    private String introduction;
}
