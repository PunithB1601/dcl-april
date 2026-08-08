package com.dcl;

public class Petrol implements Engine {

	public Petrol() {
		System.out.println("Petrol");
	}
	
	@Override
	public boolean startEngine() {
		System.out.println("Petrol engine started");
		return true;
	}

}
