package com.example.myhealthblock.doctor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorSignUpDTO {
    String id;
    String pw;
    String role;
    String name;
    String field;
    String hospital;
    String introduction;
}
