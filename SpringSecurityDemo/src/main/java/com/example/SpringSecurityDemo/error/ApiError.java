package com.example.SpringSecurityDemo.error;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Getter
public class ApiError {
    private LocalDateTime timeStamp;
    private String message;
    private HttpStatus statusCode;
}
