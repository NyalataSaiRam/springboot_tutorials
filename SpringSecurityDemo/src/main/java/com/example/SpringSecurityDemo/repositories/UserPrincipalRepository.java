package com.example.SpringSecurityDemo.repositories;

import com.example.SpringSecurityDemo.model.UserPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPrincipalRepository extends JpaRepository<UserPrincipal, Long> {
    Optional<UserPrincipal> findByUsername(String username);
    Boolean existsByUsername(String username);
}