package com.example.SpringSecurityDemo.services;

import com.example.SpringSecurityDemo.dtos.UserPrincipalRequestDTO;
import com.example.SpringSecurityDemo.model.UserPrincipal;
import com.example.SpringSecurityDemo.model.types.Role;
import com.example.SpringSecurityDemo.repositories.UserPrincipalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPrincipalService {

    private final UserPrincipalRepository userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public void register(UserPrincipalRequestDTO user) throws Exception {
        if(userRepo.existsByUsername(user.getUsername())) throw new Exception("Username already exists");
        userRepo.save(
                UserPrincipal.builder()
                    .username(user.getUsername())
                    .password(
                            encoder.encode(user.getPassword())
                    ).role(Role.USER).build()
        );
    }

    public List<UserPrincipal> getAll(){
        return userRepo.findAll();
    }





}
