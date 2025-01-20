package com.dinh.networth.Services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class AuthenticationService {
    @Value("${security.jwt.key")
    private String key;

    @Value("${security.jwt.expiration-time")
    private Long expirationTime;

    // Lazy evaluation
    private SecretKey secretKey;

    public Long getExpirationTime() {
        return expirationTime;
    }

    public String generateToken(UserDetails user) {
       return generateToken(new HashMap<>(), user);
    }

    public String generateToken(Map<String, Object> claims, UserDetails user) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getKey())
                .compact();
    }

    // Determines algorithm to use from key
    private SecretKey getKey() {
        if (secretKey != null) {
            return secretKey;
        }
        secretKey= Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
        return secretKey;
    }

    public boolean validateToken(String token, UserDetails user) {
        String tokenUsername= extractUsername(token);
        return (user.getUsername().equals(tokenUsername) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAlLClaims(token);
        return claimsResolver.apply(claims);
    }

    public boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    public Claims extractAlLClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
