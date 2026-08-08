package com.dcl.runner;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dcl.entity.Profile;
import com.dcl.entity.User;
import com.dcl.service.UserService;

@Component
public class TestRunner implements CommandLineRunner{

	@Autowired
	private UserService uservice;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1=new User();
		u1.setUsername("raju");
		u1.setEmail("raju@gmail.com");
		u1.setPassword("1234");
		
		Profile p1=new Profile();
		p1.setFname("Raju");
		p1.setLname("Sharma");
		p1.setPhone("1234523456");
		p1.setDob(LocalDate.now());
		p1.setUser(u1);
		
		uservice.saveUser(u1, p1);
		
		
		
	}

}
