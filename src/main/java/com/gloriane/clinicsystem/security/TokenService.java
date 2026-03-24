package com.gloriane.clinicsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private JwtUtil jwtUtil;

    // Called after successful login — returns a signed JWT for the user's email
    public String issueToken(String email) {
        return jwtUtil.generateToken(email);
    }

    // Called on protected requests — returns the email if token is valid, null otherwise
    public String validateAndExtract(String token) {
        if (token != null && jwtUtil.isTokenValid(token)) {
            return jwtUtil.extractEmail(token);
        }
        return null;
    }
}
