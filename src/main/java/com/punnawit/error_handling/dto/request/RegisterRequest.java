package com.punnawit.error_handling.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RegisterRequest {

    @NotBlank
    @Email
    @Size(max = 100, message = "Email must be at least 100 characters long")
    private String email;

    @NotBlank
    @Size(min = 8, max = 255, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank
    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String phoneNumber;

    @NotBlank
    @Size(max = 100, message = "First name must be at least 100 characters long")
    private String firstName;

    @NotBlank
    @Size(max = 100, message = "Last name must be at least 100 characters long")
    private String lastName;

}
