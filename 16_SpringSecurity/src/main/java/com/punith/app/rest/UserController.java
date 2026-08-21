package com.punith.app.rest;



import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.punith.app.entity.User;
import com.punith.app.service.CustomUserDetails;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminEndpoint() {
    	CustomUserDetails customUserDetails=(CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user=customUserDetails.getUser();
    	System.out.println("Getting user details from SecurityContext Holder!!!");
    	System.out.println("Data Taken from CustomerUserDetails:"+user.getEmail());
        return "Admin access granted";
    }
    
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userEndpoint() {
        return "User access granted";
    }
    
    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public access granted";
    }
}