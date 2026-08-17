package com.dcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.cresponse.ApiResponse;
import com.dcl.dto.UserDto;
import com.dcl.entity.User;
import com.dcl.exception.AppException;
import com.dcl.request.LoginRequest;
import com.dcl.request.RegisterRequest;
import com.dcl.service.SecurityService;
import com.dcl.service.UserService;

@RestController
@RequestMapping("/user")
public class DemoController {

	@Autowired
	private UserService uservice;
	
	//for email validation we require
	@Autowired
	private SecurityService sservice;
	
	//for password validation we require
	@Autowired
	private PasswordEncoder encoder;
	
	//He is the one who performs validation
	@Autowired
	private AuthenticationManager authManager;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest request){
		UserDto dto=uservice.register(request);
		return ResponseEntity.ok(new ApiResponse<>("User registration successful",dto,HttpStatus.OK));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request){
		//Email validation by using Security's UserDetailsService.loadUserByUsername(email);
		//will return security User obj, hence storing it inside UserDetails interface
		//security User -implements-> UserDetails
		UserDetails details=sservice.loadUserByUsername(request.getEmail());
		//Now loadUserByUsername is under execution, if user found it returns security User obj(UserDetails) else,
		//throws AppException. That logic available in securityService or UserDetailsService
		
		//Password Validation by using PasswordEncoder
		//matches() encodes both parameters and checks both matches or what,
		//if matches returns true, else returns false
		//We are storing that result in isMatches variable
		Boolean isMatches=encoder.matches(request.getPassword(), details.getPassword());
		
		//if password not matched
		if(!isMatches) {
			throw new AppException("Incorrect Password!", HttpStatus.UNAUTHORIZED);
		}
		
		//AuthenticationManager needs to authenticate,
		//but expect credentials in the form of tokens,
		//So, we are creating tokens by passing our credentials inside 
		//constructor of UserNamePasswordAuthenticationToken
		//which returns our credentials in the form of token obj
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
		
		//token obj is passed inside authManager.authenticate().
		//After authentication, aauthenticate() returns Authentication obj where the authentication result will be available
		
		Authentication authentication =authManager.authenticate(token);
		
		//if we want authentication result, them 
		//isAuthenticated() will give us result which is present in Authentication obj
		//if authentication success, isAuthenticated returns true, if fails returns false.
		Boolean result=authentication.isAuthenticated();
		
		//if authentication failed, ie false
		if(!result) {
			throw new AppException("Authentication Failed!", HttpStatus.UNAUTHORIZED);
		}
		
		//final result of authentication.
		return ResponseEntity.ok(new ApiResponse<>("Login successful!",null,HttpStatus.OK));
		
	}
	
}
