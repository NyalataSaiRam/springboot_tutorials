package com.example.AuthenticationTutorial.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomUserService {
    List<User> getAllUsers();
}
