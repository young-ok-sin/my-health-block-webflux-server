package com.example.myhealthblock.user;

import com.example.myhealthblock.user.dto.UserSignInDTO;
import com.example.myhealthblock.user.dto.UserSignUpDTO;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/test/sign-up")
    public String signUp(@RequestBody UserSignUpDTO body) {
        return userService.signUp(body);
    }

    @PostMapping("/v1/sign-in")
    public String signIn(@RequestBody UserSignInDTO body) {
        return userService.signIn(body);
    }
}
