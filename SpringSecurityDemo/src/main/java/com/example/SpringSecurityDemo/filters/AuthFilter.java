package com.example.SpringSecurityDemo.filters;

import com.example.SpringSecurityDemo.auth.JwtService;
import com.example.SpringSecurityDemo.models.UserPrincipal;
import com.example.SpringSecurityDemo.services.UserPrincipalService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserPrincipalService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authentication = request.getHeader("Authorization");

        if(authentication == null || !authentication.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = authentication.split(" ")[1];

        String username = jwtService.getUsernameFromToken(token);



        if(username != null || SecurityContextHolder.getContext().getAuthentication() == null){
            UserPrincipal user = userService.getUserByUsername(username);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }
}
