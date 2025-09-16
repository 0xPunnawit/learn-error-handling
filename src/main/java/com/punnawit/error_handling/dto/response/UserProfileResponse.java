package com.punnawit.error_handling.dto.response;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class UserProfileResponse {

    public UserProfileResponse(Long id, String email, String phoneNumber, String firstName, String lastName, OffsetDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
    }

    private Long id;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private OffsetDateTime createdAt;
}
