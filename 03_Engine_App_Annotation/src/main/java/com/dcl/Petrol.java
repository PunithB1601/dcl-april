package com.dcl;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("petrol")
public class Petrol implements Engine {

	public Petrol() {
		System.out.println("Petrol con called");
	}
	
	@Override
	public void start() {
		System.out.println("Petrol engine started");
	}

}
