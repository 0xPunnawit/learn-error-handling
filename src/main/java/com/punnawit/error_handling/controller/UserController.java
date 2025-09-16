package com.punnawit.error_handling.controller;

import com.punnawit.error_handling.dto.response.SessionUserPrincipal;
import com.punnawit.error_handling.dto.response.UserProfileResponse;
import com.punnawit.error_handling.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponse> userProfile(@AuthenticationPrincipal SessionUserPrincipal me) {
        return ResponseEntity.ok(userService.getUserProfile(me));
    }

}
