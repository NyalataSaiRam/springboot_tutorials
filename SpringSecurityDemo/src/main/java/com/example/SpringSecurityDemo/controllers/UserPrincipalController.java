package com.example.SpringSecurityDemo.controllers;

import com.example.SpringSecurityDemo.dtos.UserPrincipalRequestDTO;
import com.example.SpringSecurityDemo.model.UserPrincipal;
import com.example.SpringSecurityDemo.repositories.UserPrincipalRepository;
import com.example.SpringSecurityDemo.services.UserPrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserPrincipalController {

   private final UserPrincipalService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(
            @RequestBody UserPrincipalRequestDTO user
            ) throws Exception {
        userService.register(user);
        return ResponseEntity.ok("user created!");
    }

    @GetMapping("/")
    public ResponseEntity<?> fetchUsers(){
        List<UserPrincipal> all = userService.getAll();
        return ResponseEntity.ok(all);
    }
}
