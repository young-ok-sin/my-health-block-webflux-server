package com.example.myhealthblock.doctor.adapter.in;

import com.example.myhealthblock.doctor.DoctorService;
import com.example.myhealthblock.doctor.dto.DoctorSignUpDTO;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/v1/doctor/sign-up")
    public Map<String, String> signUp(@RequestBody DoctorSignUpDTO body) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", doctorService.signUp(body));
        return map;
    }
}
