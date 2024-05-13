package com.example.myhealthblock.doctor.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.doctor.DoctorService;
import com.example.myhealthblock.doctor.adapter.in.request.RequestDoctorSignUp;
import com.example.myhealthblock.doctor.adapter.in.request.RequestPatientUrgentData;
import com.example.myhealthblock.doctor.adapter.in.response.ResponsePatientUrgentData;
import com.example.myhealthblock.doctor.adapter.in.response.ResponseResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/v1/doctor/sign-up")
    public ResponseResult signUp(@RequestBody RequestDoctorSignUp body) {
        ResponseResult response = new ResponseResult();
        response.setResult(doctorService.signUp(body));
        return response;
    }

    @PostMapping("/v1/doctor/get-patient-urgent-data")
    public ResponsePatientUrgentData getPatientUrgentData(@RequestBody RequestPatientUrgentData body) {
        ResponsePatientUrgentData response = new ResponsePatientUrgentData();
        response.setPatientUrgentData(doctorService.getPatientUrgentData(body));
        return response;
    }
}
