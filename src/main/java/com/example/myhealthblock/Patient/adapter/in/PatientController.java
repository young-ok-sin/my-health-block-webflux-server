package com.example.myhealthblock.patient.adapter.in;

import com.example.myhealthblock.patient.PatientService;
import com.example.myhealthblock.patient.dto.PatientEnrollUrgentDataDTO;
import com.example.myhealthblock.patient.dto.PatientGetUrgentDataDTO;
import com.example.myhealthblock.patient.dto.PatientSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/v1/patient/sign-up")
    public Map<String, String> signUp(@RequestBody PatientSignUpDTO body){
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", patientService.signUp(body));
        return map;
    }

    @PostMapping("/v1/patient/enroll-urgent-data")
    public Map<String, String> enrollUrgentData(@RequestBody PatientEnrollUrgentDataDTO body){
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", patientService.enrollUrgentData(body));
        return map;
    }

    @PostMapping("/v1/patient/get-my-urgent-data")
    public Map<String, String> getMyUrgentData(@RequestBody PatientGetUrgentDataDTO body){
        Map<String, String> map = new HashMap<String, String>();
        map.put("myUrgentContent", patientService.getMyUrgentData(body));
        return map;
    }
}
