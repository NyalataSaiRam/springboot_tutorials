package com.example.SpringSecurityDemo.auth;

import com.example.SpringSecurityDemo.dto.AuthRequestDto;
import com.example.SpringSecurityDemo.dto.LoginResponseDto;
import com.example.SpringSecurityDemo.models.UserPrincipal;
import com.example.SpringSecurityDemo.services.UserPrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserPrincipalService userService;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;


    public LoginResponseDto login(AuthRequestDto authRequestDto) {
//        UserPrincipal user = userService.getUserByUsername(authRequestDto.getUsername());

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword());
        Authentication authenticate = authManager.authenticate(token);

        String jwt ="";
        if(authenticate.isAuthenticated()){
            jwt = jwtService.generateJwt((UserPrincipal) authenticate.getPrincipal());
        }

        return LoginResponseDto.builder().jwt(jwt).build();
    }

    public void signup(AuthRequestDto authRequestDto) {
        userService.saveUser(authRequestDto);
    }
}
