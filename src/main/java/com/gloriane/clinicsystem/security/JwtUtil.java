package com.gloriane.clinicsystem.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component  // Tells Spring to manage this class
public class JwtUtil {

    // Secret key used to sign tokens — keep this private
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // How long a token is valid — 10 hours in milliseconds
    private final long EXPIRY = 1000 * 60 * 60 * 10;

    // Creates a JWT token for a given email
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)                          // Who the token is for
                .setIssuedAt(new Date())                    // When it was created
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRY))
                .signWith(key)                              // Sign it with our secret key
                .compact();
    }

    // Reads the email out of a token
    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Checks if a token is still valid (not expired, not tampered with)
    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}