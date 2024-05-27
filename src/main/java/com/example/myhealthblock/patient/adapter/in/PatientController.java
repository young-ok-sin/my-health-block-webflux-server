package com.example.myhealthblock.patient.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.patient.PatientService;
import com.example.myhealthblock.patient.adapter.in.request.*;
import com.example.myhealthblock.patient.adapter.in.response.ResponseMyUrgentData;
import com.example.myhealthblock.patient.adapter.in.response.ResponsePatientUrgentDataViewHistory;
import com.example.myhealthblock.patient.adapter.in.response.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Patient", description = "Endpoints for Patient")
@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PatientController {
    private final PatientService patientService;

    @Operation(summary = "환자 회원가입", description = "아이디, 패스워드 등록")
    @PostMapping("/v1/patient/sign-up")
    public ResponseEntity<ResponseResult> signUp(@RequestBody RequestPatientSignUp body){
        ResponseResult response = new ResponseResult();
        response.setResult(patientService.signUp(body));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "긴급 데이터 등록", description = "응급 상황 대비 긴급 데이터 등록")
    @PostMapping("/v1/patient/enroll-urgent-data")
    public ResponseEntity<ResponseResult> enrollUrgentData(@RequestBody RequestPatientEnrollUrgentData body){
        ResponseResult response = new ResponseResult();
        response.setResult(patientService.enrollUrgentData(body));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "긴급 데이터 조회", description = "긴급 데이터 조회")
    @PostMapping("/v1/patient/get-my-urgent-data")
    public ResponseEntity<ResponseMyUrgentData> getMyUrgentData(@RequestBody RequestPatientGetUrgentData body){
        ResponseMyUrgentData response = new ResponseMyUrgentData();
        response.setMyUrgentContent(patientService.getMyUrgentData(body));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "긴급 데이터 삭제", description = "긴급 데이터 삭제 <br>{patientId}는 회원가입 아이디")
    @DeleteMapping({"/v1/patient/urgent-data/{patientId}", "/test-0/patient/urgent-data/{patientId}"})
    public ResponseEntity<ResponseResult> deleteUrgentData(@PathVariable String patientId){
        return ResponseEntity.ok(new ResponseResult(patientService.deleteUrgentData(patientId)));
    }

    @Operation(summary = "긴급 데이터 열람 기록 조회", description = "의료진이 긴급 데이터 열람한 기록 조회 <br>{patientId}는 회원가입 아이디")
    @GetMapping({"/v1/patient/{patientId}/urgent-data-view-history", "/test-0/patient/{patientId}/urgent-data-view-history"})
    public ResponseEntity<ResponsePatientUrgentDataViewHistory> getViewHistory(@PathVariable String patientId) {
        return ResponseEntity.ok(new ResponsePatientUrgentDataViewHistory(patientService.getViewHistory(patientId)));
    }
}
