package com.punith.app.response;



import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String message;
    private String role;
    
    public LoginResponse(String token, String message, String role) {
        this.token = token;
        this.message = message;
        this.role = role;
    }
}
