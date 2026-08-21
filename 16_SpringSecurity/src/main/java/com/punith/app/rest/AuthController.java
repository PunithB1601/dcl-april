package com.punith.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.punith.app.entity.User;
import com.punith.app.exception.UserException;
import com.punith.app.request.LoginRequest;
import com.punith.app.request.RegisterRequest;
import com.punith.app.response.LoginResponse;
import com.punith.app.service.UserService;
import com.punith.app.utils.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserService userService;
    
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
      
        User user = userService.findByEmail(loginRequest.getEmail());
        
        if(user ==null)
        {
        	throw new UserException("user Not Found", HttpStatus.NOT_FOUND);
        }
        
        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
        {
        	throw new UserException("Invalid Password", HttpStatus.BAD_REQUEST);
        }
        
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole());
        
        String token = jwtUtil.generateToken(user.getEmail(), claims);
        System.out.println("Token:"+token);
        String message = "USER".equals(user.getRole()) ? "User login successful" : "Admin login successful";
        
        return ResponseEntity.ok(new LoginResponse(token, message, user.getRole()));
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        // Check if user already exists
        if (userService.findByEmail(registerRequest.getEmail()) != null) {
            return ResponseEntity.badRequest().body("User already exists with this email");
        }
        // Validate role
        if (!"ADMIN".equals(registerRequest.getRole()) && !"USER".equals(registerRequest.getRole())) {
            return ResponseEntity.badRequest().body("Role must be either ADMIN or USER");
        }
        
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setRole(registerRequest.getRole());
        
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
}