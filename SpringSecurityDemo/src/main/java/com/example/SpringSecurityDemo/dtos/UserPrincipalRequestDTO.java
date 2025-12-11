package com.example.SpringSecurityDemo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPrincipalRequestDTO {

    private String username;

    private String password;
}
