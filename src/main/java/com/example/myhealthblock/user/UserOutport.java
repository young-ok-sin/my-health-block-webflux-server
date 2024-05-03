package com.example.myhealthblock.user;

public interface UserOutport {
    public boolean create(String id, String pw, String role);

    public User getUser(String id);
}
