package com.example.myhealthblock.user;


import com.example.myhealthblock.user.dto.UserSignInDTO;
import com.example.myhealthblock.user.dto.UserSignUpDTO;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserAdapter outport;

    public String signUp(UserSignUpDTO dto) {
        return outport.create(dto.getId(), dto.getPw(), dto.getRole()) ? "success" : "fail";
    }


    public String signIn(UserSignInDTO dto) {
        User user = outport.getUser(dto.getId());

        return (user != null) && user.signIn(dto.getPw()) ? "success" : "fail";
    }
}
