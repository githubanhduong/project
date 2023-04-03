package com.cybersoft.osahaneat.utils;

import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtilsHelpers {
    @Value("${jwt.privateKey}")
    private String privateKey;

    public String generateToken(String data) {
        long expriredTime = 1000*1000;

        SecretKey secretKey = Keys.hmacShaKeyFor(privateKey.getBytes());
//        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey)); // cach 2

        Date date = new Date();
        long currentDateMilis = date.getTime() + expriredTime;
        Date expiredDate = new Date(currentDateMilis);

        String jwt = Jwts.builder()
                .setSubject(data)// Du lieu muon luu kem khi ma hoa JWT de sau nay lay ra su dung
                .signWith(secretKey) // Key ma hoa
                .setExpiration(expiredDate)
                .compact();
        return jwt;
    }

    public boolean verifyToken(String token) {
        try {
            SecretKey secretKey = Keys.hmacShaKeyFor(privateKey.getBytes());
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getDataFromToken(String token) {
        try {
            SecretKey secretKey = Keys.hmacShaKeyFor(privateKey.getBytes());
            return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
        } catch (Exception e) {
            return "";
        }
    }

}
