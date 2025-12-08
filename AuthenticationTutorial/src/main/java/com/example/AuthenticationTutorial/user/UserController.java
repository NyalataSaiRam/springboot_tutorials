package com.example.AuthenticationTutorial.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final CustomUserService customUserService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(customUserService.getAllUsers());
    }

}
