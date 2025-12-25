package com.example.SpringSecurityDemo.repositories;

import com.example.SpringSecurityDemo.models.UserPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPrincipalRepo extends JpaRepository<UserPrincipal, Long> {

    Optional<UserPrincipal> findByUsername(String username);
}
