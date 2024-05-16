package com.example.myhealthblock.patient.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.patient.PatientService;
import com.example.myhealthblock.patient.adapter.in.request.*;
import com.example.myhealthblock.patient.adapter.in.response.ResponseMyUrgentData;
import com.example.myhealthblock.patient.adapter.in.response.ResponsePatientUrgentDataViewHistory;
import com.example.myhealthblock.patient.adapter.in.response.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/test-0/patient/urgent-data/{id}")
    public ResponseResult deleteUrgentData(@PathVariable String id){
        return new ResponseResult();
    }

    @GetMapping("/test-0/patient/{id}/urgent-data-view-history")
    public ResponsePatientUrgentDataViewHistory getViewHistory(@PathVariable String id) {
        return new ResponsePatientUrgentDataViewHistory();
    }
}
