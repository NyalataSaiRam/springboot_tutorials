package com.example.SpringSecurityDemo.error;

import io.jsonwebtoken.JwtException;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiError> usernameNotFoundExceptionHandler(UsernameNotFoundException exception){
        ApiError build = ApiError.builder()
                .timeStamp(LocalDateTime.now())
                .message("Username not found!")
                .statusCode(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(build, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> authenticationExceptionHandler(AuthenticationException exception){
        ApiError apiError = ApiError.builder()
                .timeStamp(LocalDateTime.now())
                .message("Authentication failed!")
                .statusCode(HttpStatus.UNAUTHORIZED)
                .build();

        return new ResponseEntity<>(apiError, apiError.getStatusCode() );
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError> jwtExceptionHandler(JwtException exception){
        ApiError apiError = ApiError.builder()
                .timeStamp(LocalDateTime.now())
                .message("Invalid token")
                .statusCode(HttpStatus.UNAUTHORIZED)
                .build();

        return new ResponseEntity<>(apiError, apiError.getStatusCode() );
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> accessDeniedExceptionHandler(AccessDeniedException exception){
        ApiError apiError = ApiError.builder()
                .timeStamp(LocalDateTime.now())
                .message("Access denied: Insufficient permissions")
                .statusCode(HttpStatus.FORBIDDEN)
                .build();

        return new ResponseEntity<>(apiError, apiError.getStatusCode() );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> exceptionHandler(Exception exception){
        ApiError apiError = ApiError.builder()
                .timeStamp(LocalDateTime.now())
                .message(exception.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();

        return new ResponseEntity<>(apiError, apiError.getStatusCode() );
    }
}
