package com.example.AuthenticationTutorial.auth;

import com.example.AuthenticationTutorial.config.JWTService;
import com.example.AuthenticationTutorial.user.Role;
import com.example.AuthenticationTutorial.user.User;
import com.example.AuthenticationTutorial.user.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public @Nullable AuthenticationResponse register(RegisterRequest request, HttpServletResponse response) {
        var user = User.builder()
                .fullname(request.getFullname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        addJwtToCookie(response, jwtToken);

        return AuthenticationResponse.builder().message("successful").build();
    }

    public @Nullable AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        addJwtToCookie(response, jwtToken);

        return AuthenticationResponse.builder()
                .message("successful")
                .build();
    }

    private void addJwtToCookie(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);               // JS cannot access it (IMPORTANT)
        cookie.setSecure(true);                 // send only over HTTPS
        cookie.setPath("/");                    // allowed for entire application
        cookie.setMaxAge(24 * 60 * 60);         // 1 day
        cookie.setAttribute("SameSite", "Strict"); // or "Lax"
        response.addCookie(cookie);
    }
}
