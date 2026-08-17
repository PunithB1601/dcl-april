package com.dcl.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dcl.entity.User;
import com.dcl.exception.AppException;
import com.dcl.repo.UserRepo;

//The implementation written for inbuilt UserDetailsService interface
//an inbuilts service interface give by security 
@Service
public class SecurityService implements UserDetailsService{

	@Autowired
	private UserRepo urepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User u=urepo.findByEmail(email).orElseThrow(()->new AppException("User Not Found!",HttpStatus.NOT_FOUND));
		//here, this method returns Security User obj
		//but DB returns Entity User obj.
		//So we created security User obj by using new User() and passed our credentials as parameter
		return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), Collections.EMPTY_LIST);
		//                                                        email from entity, pwd from entity,  we have no role-based, so empty constructor passed
	}

}
