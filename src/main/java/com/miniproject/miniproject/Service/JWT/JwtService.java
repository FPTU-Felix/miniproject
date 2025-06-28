package com.miniproject.miniproject.Service.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {
    //Tao khoa bi mat de ky JWT
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    //Trich xuat username tu token
    public String extractUsername(String token) {
        return extractC
    }
    //Trich xuat thong tinh tu bat ky token
    public String

    //Trich xuat tat ca cac claims tu JWT
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
