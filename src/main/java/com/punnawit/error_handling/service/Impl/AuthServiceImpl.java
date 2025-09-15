package com.punnawit.error_handling.service.Impl;

import com.punnawit.error_handling.dto.request.LoginRequest;
import com.punnawit.error_handling.dto.request.RegisterRequest;
import com.punnawit.error_handling.dto.response.LoginResponse;
import com.punnawit.error_handling.dto.response.RegisterResponse;
import com.punnawit.error_handling.dto.response.UserSummary;
import com.punnawit.error_handling.model.User;
import com.punnawit.error_handling.repository.UserRepository;
import com.punnawit.error_handling.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // ================== Register ==================
    @Override
    @Transactional
    public RegisterResponse register(RegisterRequest request) {

        final String email = request.getEmail().trim().toLowerCase();

        boolean checkEmail = userRepository.existsByEmail(email);
        if (checkEmail) {
            throw new RuntimeException("Email already exists");
        }

        boolean checkPhoneNumber = userRepository.existsByPhoneNumber(request.getPhoneNumber());
        if (checkPhoneNumber) {
            throw new RuntimeException("Phone number already exists");
        }

        User user = User.builder()
                .email(email)
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .createdAt(OffsetDateTime.now())
                .build();

        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            // ด่านสุดท้าย: DB UNIQUE ลั่น (กันสมัครชนกันพอดี)
            // TODO: map ตาม constraint name เพื่อบอกได้ว่า email หรือ phone ซ้ำ
            throw new RuntimeException("map ตาม constraint name เพื่อบอกได้ว่า email หรือ phone ซ้ำ");
        }

        return new RegisterResponse("Register Successful");
    }


    // ================== Login ==================
    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<User> byEmail = userRepository.findByEmail(request.getEmail());
        if (byEmail.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = byEmail.get();
        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid password");
        }

        return new LoginResponse(
                "Login Successful",
                new UserSummary(user.getId(), user.getEmail())
        );

    }

}
