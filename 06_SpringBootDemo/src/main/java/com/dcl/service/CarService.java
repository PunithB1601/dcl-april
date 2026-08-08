package com.dcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.beans.Engine;

@Service
public class CarService {

	
	private Engine eng;
	
	
	
	public CarService(Engine eng) {
		this.eng=eng;
		System.out.println("con called");
		System.out.println(eng);
	}
	
	
	
	public void revv() {
		eng.start();
		System.out.println("Car started");
	}
	
}
