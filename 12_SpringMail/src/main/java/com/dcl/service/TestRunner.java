package com.dcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner{

	@Autowired
	private EmailService eservice;
	
	@Override
	public void run(String... args) throws Exception {
	//	Boolean status=eservice.sendMail("punithbasavaraj16@gmail.com");
		Boolean status=eservice.sendHtmlMail("punithbasavaraj16@gmail.com");
		if(status) {
			System.out.println("Mail sent");
		}
	}
	
	
	
	

}
