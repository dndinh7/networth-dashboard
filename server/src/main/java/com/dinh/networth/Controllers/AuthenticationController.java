package com.dinh.networth.Controllers;

import com.dinh.networth.Helpers.JwtAuthenticationUtility;
import com.dinh.networth.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtAuthenticationUtility jwtAuthenticationUtility;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> login(RegisterRequest request) {
        userService.addUser(request.getName(), request.getEmail(), request.getPassword());
        return ResponseEntity.ok("Successfully registered");
    }

    @PostMapping("/login")

}

class LoginRequest {

}

class LoginResponse {

}

class RegisterRequest {
    private String email;
    private String password;
    private String name;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}

class RegisterResponse {

}
