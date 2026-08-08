package com.dcl;

public class Car {
	
	private Engine eng;
	
	public Car() {
		System.out.println("0-param-Car");
	}
	
	public void setEng(Engine eng) {
		this.eng=eng;
		System.out.println("setter() called");
	}
	
	public Car(Engine eng) {
		this.eng=eng;
		System.out.println("param-Car");
	}
	
	public void revv() {
	
		boolean status=eng.startEngine();
		if(status) {
			System.out.println("Car moving");
		}
		else {
			System.out.println("Car failed to move");
		}
	
		
	}
}
