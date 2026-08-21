package com.punith.app.utils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.punith.app.rest.UserController;
import com.punith.app.service.CustomUserDetailsService;

import java.io.IOException;
import java.util.Collection;

//it wil work when every request sent
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final UserController userController; //AC
    @Autowired
	private  JwtUtil jwtUtil; //work with jwttoken
    @Autowired
    private  CustomUserDetailsService customUserDetailsService;

    JwtRequestFilter(UserController userController) {
        this.userController = userController;
    } //load info from DB

//    public JwtRequestFilter(JwtUtil jwtUtil, CustomUserDetailsService userDetailsService) {
//        this.jwtUtil = jwtUtil;
//        this.customUserDetailsService = userDetailsService;
//    }

    //this method will be called for every request
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

    	//get the token from the header
        final String authorizationHeader = request.getHeader("Authorization");
        System.out.println("Token from header"+authorizationHeader);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//header start with Bearer
            String email = null;
            String jwt = authorizationHeader.substring(7);
            //remove Bearer
            System.out.println("Removed bearer:"+jwt);
            
            try {
            	//take the user email from token
                email = jwtUtil.extractSubject(jwt);
                System.out.println("email extracted:"+jwt);
            } catch (Exception e) {
                // Invalid token, continue without authentication
                chain.doFilter(request, response);
                return;
            }
            //Check if the user is not already authenticated

            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                 //load email from DB
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
                System.out.println("Passing email to the email details servvice");
                System.out.println("Getting data from database:"+userDetails.getUsername());
                Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
                System.out.println("Authorities:"+authorities);
                var authToken = new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                        userDetails, null, authorities);
                System.out.println(authToken);
                System.out.println("Authorities:"+authorities);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
                //It creates an authentication object with the user’s 
                //details and stores it in the security context
                // we can take user details where ever i want 
            }
        }
        
        System.out.println("Continue");
        chain.doFilter(request, response);
    }
}