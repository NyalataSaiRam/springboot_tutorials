package com.example.SpringSecurityDemo.config;


import com.example.SpringSecurityDemo.repositories.UserPrincipalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.HttpBasicDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

   private final UserPrincipalRepository userPrincipalRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){

        return http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request ->
                        request
                                .requestMatchers(
                                        HttpMethod.POST,
                                        "/user/signup"

                                )
                                .permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(
                        customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(
                username -> userPrincipalRepository
                        .findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("user not found!"))
        );

        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return provider;
    }
}
