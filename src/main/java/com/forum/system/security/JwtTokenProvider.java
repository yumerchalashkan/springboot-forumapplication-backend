package com.forum.system.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${code.jwt.secret}")
    private String APP_SECRET;

    @Value("${code.jwt.expiration}")
    private long EXPIRATION_TIME;

    public String generateJwtToken(Authentication authentication) {

        JwtUserDetails userDetails = (JwtUserDetails) authentication.getPrincipal();
        Date expiredDate = new Date(new Date().getTime() + EXPIRATION_TIME);
        return Jwts.builder()
                .setSubject(Long.toString(userDetails.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiredDate)
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, APP_SECRET)
                .compact();
    }

    Long getUserIdFromJwtToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(APP_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());

    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(authToken);
            return !isTokenExpired(authToken);
        } catch (Exception e) {
            System.out.println("Invalid JWT signature: " + e.getMessage());
            return false;
        }
    }

    public boolean isTokenExpired(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(APP_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration().before(new Date());
    }
}
