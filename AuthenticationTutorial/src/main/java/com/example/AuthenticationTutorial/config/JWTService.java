package com.example.AuthenticationTutorial.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JWTService {

    @Value("${app.secret-key}")
    private String SECRET_KEY;

    public String getUsername(String token) {

        return getAllClaims(token).getSubject();
    }

    public  String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000*60*60*24))
                .signWith(getSecretKey())
                .compact();
    }

    public boolean isValidToken(String token, UserDetails userDetails){
        final String jwtUsername = getUsername(token);

        if(jwtUsername.equals(userDetails.getUsername()) && isJwtNotExpired(token)){
            return true;
        }

        return false;
    }

    private boolean isJwtNotExpired(String token) {
        return getAllClaims(token).getExpiration().after(new Date());
    }


    /**
     *get the payload
     * @param token
     * @return
     */
    private Claims getAllClaims(String token){
        return Jwts.parser().verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }




}
