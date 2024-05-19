package com.example.myhealthblock.doctor.adapter.in.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDoctorSignUp {
    String id;
    String pw;
    String role;
    String name;
    String field;
    String hospital;
    String introduction;
}
