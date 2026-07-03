package com.star.spring_security_demo.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JwtService {
    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<> ();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Data(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*3))
                .signWith(getKey() , SignatureAlgorithm.HS256).compact();


    }
}
