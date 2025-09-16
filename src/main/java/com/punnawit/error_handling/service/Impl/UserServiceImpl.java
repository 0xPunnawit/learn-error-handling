package com.punnawit.error_handling.service.Impl;

import com.punnawit.error_handling.dto.response.SessionUserPrincipal;
import com.punnawit.error_handling.dto.response.UserProfileResponse;
import com.punnawit.error_handling.model.User;
import com.punnawit.error_handling.repository.UserRepository;
import com.punnawit.error_handling.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    @Transactional(readOnly = true)
    public UserProfileResponse getUserProfile(SessionUserPrincipal me) {

        if (me == null) {
            throw new RuntimeException("Not logged in");
        }

        Optional<User> byId = userRepository.findById(me.getId());
        if (byId.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = byId.get();
        return new UserProfileResponse(
                user.getId(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getFirstName(),
                user.getLastName(),
                user.getCreatedAt()
        );

    }
}
