package com.example.SpringSecurityDemo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class Admin {

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok("List of all users");
    }

}
