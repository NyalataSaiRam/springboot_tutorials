package com.example.SpringSecurityDemo.auth;

import com.example.SpringSecurityDemo.dto.AuthRequestDto;
import com.example.SpringSecurityDemo.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody AuthRequestDto authRequestDto
    ){
        LoginResponseDto loginResponseDto = authService.login(authRequestDto);

        return ResponseEntity.ok(loginResponseDto);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(
            @RequestBody AuthRequestDto authRequestDto
    ){
         authService.signup(authRequestDto);

        return ResponseEntity.ok("account creation successfull");
    }



}
