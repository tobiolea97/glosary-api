package com.daily.practice.business.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

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
