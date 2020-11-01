package com.tlc.tracker.security.repository;

import com.tlc.tracker.security.model.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositorySecurity extends JpaRepository<UserSecurity, Integer> {

	Optional<UserSecurity> findByEmail(String email);
}
