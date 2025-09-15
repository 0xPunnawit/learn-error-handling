package com.punnawit.error_handling.service;

import com.punnawit.error_handling.dto.request.LoginRequest;
import com.punnawit.error_handling.dto.request.RegisterRequest;
import com.punnawit.error_handling.dto.response.LoginResponse;
import com.punnawit.error_handling.dto.response.RegisterResponse;


public interface AuthService {

    // ================== Register ==================
    RegisterResponse register(RegisterRequest request);


    // ================== Login ==================
    LoginResponse login(LoginRequest request);

}
