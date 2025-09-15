package com.punnawit.error_handling.controller;

import com.punnawit.error_handling.dto.request.LoginRequest;
import com.punnawit.error_handling.dto.request.RegisterRequest;
import com.punnawit.error_handling.dto.response.LoginResponse;
import com.punnawit.error_handling.dto.response.RegisterResponse;
import com.punnawit.error_handling.service.AuthService;
import com.punnawit.error_handling.service.Impl.AuthServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // ================== Register ==================
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
        RegisterResponse response = authService.register(request);
        // สมัครสำเร็จ ใช้ 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    // ================== Login ==================
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        // ล็อกอินสำเร็จ ใช้ 200 OK
        return ResponseEntity.ok(response);
    }


}
