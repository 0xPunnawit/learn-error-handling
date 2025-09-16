package com.punnawit.error_handling.service;

import com.punnawit.error_handling.dto.response.SessionUserPrincipal;
import com.punnawit.error_handling.dto.response.UserProfileResponse;

public interface UserService {

    UserProfileResponse getUserProfile(SessionUserPrincipal me);
}
