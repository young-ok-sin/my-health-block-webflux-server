package com.example.myhealthblock.user.adapter.in;

import com.example.myhealthblock.aop.LogExecutionTime;
import com.example.myhealthblock.aop.LogTarget;
import com.example.myhealthblock.user.UserService;
import com.example.myhealthblock.user.adapter.in.request.RequestUserSignIn;
import com.example.myhealthblock.user.adapter.in.request.RequestUserSignUp;
import com.example.myhealthblock.user.adapter.in.response.ResponseSignIn;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@LogExecutionTime(logTarget = LogTarget.CONTROLLER)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/test/sign-up")
    public String signUp(@RequestBody RequestUserSignUp body) {
        return userService.signUp(body);
    }

    @PostMapping("/v1/sign-in")
    public ResponseSignIn signIn(@RequestBody RequestUserSignIn body) {
        return userService.signIn(body).getRequestBody();
    }
}
