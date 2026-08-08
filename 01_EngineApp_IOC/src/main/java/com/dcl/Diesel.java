package com.dcl;

public class Diesel implements Engine {

	public Diesel() {
		System.out.println("Diesel");
	}
	@Override
	public boolean startEngine() {
		System.out.println("Diesel engine started");
		return true;
	}

}
