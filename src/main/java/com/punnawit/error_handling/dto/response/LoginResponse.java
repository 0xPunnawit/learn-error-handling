package com.punnawit.error_handling.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private String message;
    private UserSummary user;

}
