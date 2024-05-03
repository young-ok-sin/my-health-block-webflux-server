package com.example.myhealthblock.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
    String id;
    String pw;
    String role;

    public boolean signIn(String pw) {
        return this.pw.equals(pw);
    }
}
