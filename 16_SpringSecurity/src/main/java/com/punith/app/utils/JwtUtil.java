package com.punith.app.utils;



import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.punith.app.exception.UserException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {
    
    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("cgsdhjcvdfbvmbfgyuguyuydvbkfdbkjvbdkjfbvkjfdbvkjfd".getBytes());

    public String generateToken(String email ,Map<String, Object> tokenClaims) {
        Map<String, Object> claims = tokenClaims;
        System.out.println("Token gen");
        return Jwts.builder() //it builds the token
                .setClaims(claims)//role
                .setSubject(email)//email
                .setIssuedAt(new Date())//date
                .signWith(SECRET_KEY,SignatureAlgorithm.HS256 )//(it sign the token )data and key-->algorithm
                .compact(); // return jwt token
    }

    public String extractSubject(String token) { //takes the token and return email
        String details=null;
        try {
            details = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY) 
                    .build()
            // check and validate the token 
                    //using the secret key
                    .parseClaimsJws(token) //parse token using key  
                    .getBody()
                    .getSubject(); //take sub like email (subject)
        } catch (Exception e) {
            throw new UserException("Invalid Token",HttpStatus.UNAUTHORIZED);
        }
        
        return details;
    }
    
    public Map<String, Object> extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token) 
                .getBody(); 
    }
     
   
}