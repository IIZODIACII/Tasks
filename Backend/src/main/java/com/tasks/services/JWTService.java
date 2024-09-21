package com.tasks.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JWTService {

    private SecretKey key = Jwts.SIG.HS256.key().build();

    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<String, Object>();
        Date currentDate = new Date(System.currentTimeMillis());

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(currentDate)
                .expiration(new Date(currentDate.getTime() + (30 * 60 * 1000)))
                .and()
                .signWith(getKey())
                .compact();
    }

    private SecretKey getKey() {
        return key;
    }

    public String extractUserName(String token) {
        // extract the username from jwt token
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

}
