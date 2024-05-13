package com.example.myhealthblock.patient.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.patient.PatientService;
import com.example.myhealthblock.patient.adapter.in.request.RequestPatientEnrollUrgentData;
import com.example.myhealthblock.patient.adapter.in.request.RequestPatientGetUrgentData;
import com.example.myhealthblock.patient.adapter.in.request.RequestPatientSignUp;
import com.example.myhealthblock.patient.adapter.in.response.ResponseMyUrgentData;
import com.example.myhealthblock.patient.adapter.in.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/v1/patient/sign-up")
    public ResponseResult signUp(@RequestBody RequestPatientSignUp body){
        ResponseResult response = new ResponseResult();
        response.setResult(patientService.signUp(body));
        return response;
    }

    @PostMapping("/v1/patient/enroll-urgent-data")
    public ResponseResult enrollUrgentData(@RequestBody RequestPatientEnrollUrgentData body){
        ResponseResult response = new ResponseResult();
        response.setResult(patientService.enrollUrgentData(body));
        return response;
    }

    @PostMapping("/v1/patient/get-my-urgent-data")
    public ResponseMyUrgentData getMyUrgentData(@RequestBody RequestPatientGetUrgentData body){
        ResponseMyUrgentData response = new ResponseMyUrgentData();
        response.setMyUrgentContent(patientService.getMyUrgentData(body));
        return response;
    }
}
