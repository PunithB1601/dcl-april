package com.punith.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//http://localhost:8085/swagger-ui/index.html#/
@SpringBootApplication
@EnableMethodSecurity 
//want to control access to certain methods 
//based on user
//roles or permissions.
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		
		
	}

}
