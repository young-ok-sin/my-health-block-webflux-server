package com.example.myhealthblock.user.adapter.in.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUserUpdatePw {
    private String oldPw;
    private String newPw;
}
