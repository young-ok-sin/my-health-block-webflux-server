package com.example.myhealthblock.Patient;

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
}
