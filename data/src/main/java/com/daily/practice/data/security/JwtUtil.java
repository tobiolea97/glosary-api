package com.daily.practice.data.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    public Boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(SecurityConstants.JWT_FIRMA).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("Invalid token");
        }
    }

    public String getUsernameByToken (String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_FIRMA)
                .parseClaimsJws(jwt)
                .getBody();
        return claims.getSubject();
    }

}

