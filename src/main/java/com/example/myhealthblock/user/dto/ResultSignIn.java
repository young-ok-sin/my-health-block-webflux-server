package com.example.myhealthblock.user.dto;

import java.util.HashMap;
import java.util.Map;

public class ResultSignIn {
    private Map<String, String> response;
    public ResultSignIn () {
        response = new HashMap<String, String>();
        response.put("result", "fail");
        response.put("role", "");
        response.put("id", "");
    }

    public void success(String role, String id) {
        response.put("result", "success");
        response.put("role", role);
        response.put("id", id);
    }

    public Map<String, String> getRequestBody() {
        return new HashMap<>(response);
    }
}
