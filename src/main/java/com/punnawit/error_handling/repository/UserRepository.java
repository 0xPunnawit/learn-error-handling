package com.punnawit.error_handling.repository;

import com.punnawit.error_handling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Login
    Optional<User> findByEmail(String email);

    // Check Email
    boolean existsByEmail(String email);

    // Check PhoneNumber
    boolean existsByPhoneNumber(String phoneNumber);


}
