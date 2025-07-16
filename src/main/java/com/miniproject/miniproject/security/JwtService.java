package com.miniproject.miniproject.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secretKey;

    private final long expirationMs = 86400000;//miliseconds

    public String gennerateToken(UserDetails userDetails){
        CustomerUserDetails customUser = (CustomerUserDetails) userDetails;
        return Jwts.builder()
                .setSubject(customUser.getUserId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    public String extractKey(String token){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        String id= extractKey(token);
        CustomerUserDetails customUser = (CustomerUserDetails) userDetails;
        return (id.equals(customUser.getUserId()) && !isTokenExpired(token));
    }
    public boolean isTokenExpired(String token){
        Date expiration = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}
