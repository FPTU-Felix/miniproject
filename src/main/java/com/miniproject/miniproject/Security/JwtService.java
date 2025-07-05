package com.miniproject.miniproject.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secretKey;

    private final long expirationMs = 86400000;//miliseconds

    public String gennerateToken(UserDetails userDetails){
        CustomerUserDetails customUser = (CustomerUserDetails) userDetails;
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", customUser.getUsername());
        claims.put("email", customUser.getEmail());
        claims.put("roles", customUser.getRoleNames());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(String.valueOf(customUser.getUserId()))//subject la id
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    public String extractUsername(String token){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        String username= extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
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
