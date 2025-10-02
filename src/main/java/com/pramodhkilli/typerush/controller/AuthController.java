package com.pramodhkilli.typerush.controller;

import com.pramodhkilli.typerush.service.AuthService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/typerush/auth")
public class AuthController {

    @Autowired private AuthService authService;

    @PostMapping("/register")
    public TokenResponse register(@RequestBody RegisterRequest req) {
        String token = authService.register(req.getUsername(), req.getEmail(), req.getPassword());
        return new TokenResponse(token);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req) {
        String token = authService.login(req.getUsername(), req.getPassword());
        return new LoginResponse(req.username,req.password,token);
    }

    @Data
    static class RegisterRequest {
        private String username;
        private String email;
        private String password;
    }

    @Data
    static class LoginRequest {
        private String username;
        private String password;
    }

    @Data
    static class TokenResponse {
        private final String token;
    }

    @Data
    static class LoginResponse{
        private String username;
        private String password;
        private String token;

        public LoginResponse(String username, String password, String token) {
            this.password = password;
            this.username = username;
            this.token = token;
        }
    }
}
