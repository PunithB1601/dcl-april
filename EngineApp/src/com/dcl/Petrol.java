package com.dcl;

public class Petrol implements Engine {

	@Override
	public boolean startEngine() {
		System.out.println("Petrol engine started");
		return true;
	}

}
