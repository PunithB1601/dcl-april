package com.punith.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.punith.app.entity.User;
import com.punith.app.repo.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User registerUser(User user) {
//    	CustomUserDetails cd= (CustomUserDetails)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User u1 = cd.getUser();
//        System.out.println(u1);
        
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}