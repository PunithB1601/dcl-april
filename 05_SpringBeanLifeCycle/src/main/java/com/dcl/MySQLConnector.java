package com.dcl;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class MySQLConnector{

	@PostConstruct
	void establishConnection() {
		System.out.println("Connection established");
	}
	
	
	void performCrud() {
		System.out.println("Crud operation performed");
	}
	
	@PreDestroy
	void removeConnection() {
		System.out.println("Connection removed");
	}


	
}
