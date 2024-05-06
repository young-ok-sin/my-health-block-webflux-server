package com.example.myhealthblock.patient.adapter.in;

import com.example.myhealthblock.patient.PatientService;
import com.example.myhealthblock.patient.dto.PatientSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/v1/patient/sign-up")
    public String signUp(@RequestBody PatientSignUpDTO body){
        return patientService.signUp(body);
    }
}
