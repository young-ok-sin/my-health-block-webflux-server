package com.example.myhealthblock.patient;

import com.example.myhealthblock.patient.adapter.out.PatientAdapter;
import com.example.myhealthblock.patient.adapter.out.PatientEntity;
import com.example.myhealthblock.patient.dto.*;
import com.example.myhealthblock.patient.dto.PatientEntityDTO;
import com.example.myhealthblock.user.UserService;
import com.example.myhealthblock.user.dto.UserSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PatientService {
    private final PatientAdapter outport;
    private final UserService userInport;

    public String signUp(PatientSignUpDTO dto){
        UserSignUpDTO user = new UserSignUpDTO();
        user.setId(dto.getId());
        user.setPw(dto.getPw());
        user.setRole(dto.getRole());

        userInport.signUp(user);

        boolean result = outport.create(dto.getId());

        return result ? "success" : "fail";
    }

    public PatientEntityDTO getPatientEntityDTO(String uid) { // interface로 노출할 필요 존재
        return outport.getUserEntityDTO(uid);
    }
}
