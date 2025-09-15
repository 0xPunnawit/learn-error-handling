package com.punnawit.error_handling.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
//@JsonIgnoreProperties(ignoreUnknown = true)      // มี Key เกินได้
public class LoginRequest {

    @NotBlank
    @Email
    @Size(max = 100, message = "Email must be at least 100 characters long")
    private String email;

    @NotBlank
    @Size(min = 8, max = 255, message = "Password must be at least 8 characters long")
    private String password;
}