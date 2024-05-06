package com.example.myhealthblock.patient;

import com.example.myhealthblock.patient.adapter.out.PatientAdapter;
import com.example.myhealthblock.patient.dto.*;
import com.example.myhealthblock.patient.dto.PatientEntityDTO;
import com.example.myhealthblock.user.UserService;
import com.example.myhealthblock.user.dto.UserSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PatientService implements GetPatientEntityDTO, GetPatientUrgentData {
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

    public String enrollUrgentData(PatientEnrollUrgentDataDTO dto){
        boolean result = outport.enrollUrgentData(dto.getId(), dto.getContent());
        return result ? "success" : "fail";
    }

    @Override
    public String getUrgentData(String id, String reason, String doctorId) {
        return outport.getUrgentData(id, reason, doctorId);
    }

    @Override
    public PatientEntityDTO getPatientEntityDTO(String uid) { // interface로 노출할 필요 존재
        return outport.getUserEntityDTO(uid);
    }
}
