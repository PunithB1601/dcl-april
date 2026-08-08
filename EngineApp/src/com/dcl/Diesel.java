package com.dcl;

public class Diesel implements Engine {

	@Override
	public boolean startEngine() {
		System.out.println("Diesel engine started");
		return true;
	}

}
