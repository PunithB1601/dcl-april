package com.dcl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Car {

	
	//@Qualifier("petrol")
	private Engine eng;
	
	public Car() {
		System.out.println("0-param car con");
	}
	
	@Autowired
	public Car(Engine eng) {
		this.eng=eng;
		System.out.println("param car con");
	}
	
	//@Qualifier("petrol")
	public void setEng(Engine eng) {
		this.eng=eng;
		System.out.println("setter() called");
	}
	
	void revv() {
		eng.start();
		System.out.println("Car started moving");
	}
}
