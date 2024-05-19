package com.example.myhealthblock.patient;

import com.example.myhealthblock.patient.adapter.in.request.RequestPatientEnrollUrgentData;
import com.example.myhealthblock.patient.adapter.in.request.RequestPatientGetUrgentData;
import com.example.myhealthblock.patient.adapter.in.request.RequestPatientSignUp;
import com.example.myhealthblock.patient.adapter.out.PatientAdapter;
import com.example.myhealthblock.patient.dto.PatientEntityDTO;
import com.example.myhealthblock.patient.dto.PatientUrgentDataViewDTO;
import com.example.myhealthblock.user.UserService;
import com.example.myhealthblock.user.adapter.in.request.RequestUserSignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PatientService implements GetPatientEntityDTO, GetPatientUrgentData {
    private final PatientAdapter outport;
    private final UserService userInport;

    public String signUp(RequestPatientSignUp dto){
        RequestUserSignUp user = new RequestUserSignUp();
        user.setId(dto.getId());
        user.setPw(dto.getPw());
        user.setRole(dto.getRole());

        userInport.signUp(user);

        boolean result = outport.create(dto.getId());

        return result ? "success" : "fail";
    }

    public String enrollUrgentData(RequestPatientEnrollUrgentData dto){
        boolean result = outport.enrollUrgentData(dto.getId(), dto.getContent());
        return result ? "success" : "fail";
    }

    public String getMyUrgentData(RequestPatientGetUrgentData dto){
        return outport.getUrgentData(dto.getId());
    }
    @Override
    public String getUrgentData(String id, String reason, String doctorId) {
        return outport.getUrgentData(id, reason, doctorId);
    }

    public String deleteUrgentData(String patientId) {
        boolean result = outport.deleteUrgentData(patientId);
        return result ? "success" : "fail";
    }

    public PatientUrgentDataViewDTO[] getViewHistory(String patientId) {
        return outport.getViewHistory(patientId);
    }

    @Override
    public PatientEntityDTO getPatientEntityDTO(String uid) { // interface로 노출할 필요 존재
        return outport.getUserEntityDTO(uid);
    }
}
