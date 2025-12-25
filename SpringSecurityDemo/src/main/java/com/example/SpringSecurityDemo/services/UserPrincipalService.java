package com.example.SpringSecurityDemo.services;

import com.example.SpringSecurityDemo.dto.AuthRequestDto;
import com.example.SpringSecurityDemo.models.UserPrincipal;
import com.example.SpringSecurityDemo.models.types.Role;
import com.example.SpringSecurityDemo.repositories.UserPrincipalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserPrincipalService {

    private final UserPrincipalRepo userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserPrincipal getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

    public void saveUser(AuthRequestDto authRequestDto) {
        UserPrincipal newUser = UserPrincipal.builder()
                .username(authRequestDto.getUsername())
                .password(
                        passwordEncoder.encode(authRequestDto.getPassword())
                )
                .role(Role.USER)
                .build();
        userRepository.save(
                newUser
        );
    }
}
