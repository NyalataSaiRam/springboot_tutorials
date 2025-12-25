package com.example.SpringSecurityDemo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class Public {

    @GetMapping
    public ResponseEntity<?> getDoctors(){
        return ResponseEntity.ok("List of docters");
    }
}
