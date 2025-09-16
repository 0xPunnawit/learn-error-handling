package com.punnawit.error_handling.dto.response;

import lombok.Getter;

@Getter
public class SessionUserPrincipal {

    public SessionUserPrincipal(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    private Long id;
    private String email;
}
