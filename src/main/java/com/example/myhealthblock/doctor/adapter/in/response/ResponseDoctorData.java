package com.example.myhealthblock.doctor.adapter.in.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDoctorData {
    private String name;
    private String field;
    private String hospital;
    private String introduction;

    public ResponseDoctorData(String name, String field, String hospital, String introduction) {
        this.name = name;
        this.field = field;
        this.hospital = hospital;
        this.introduction = introduction;
    }
}
