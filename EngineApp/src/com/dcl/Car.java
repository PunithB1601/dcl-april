package com.dcl;

public class Car {
	
	private Engine eng;
	
	public Car() {
		System.out.println("0-param-car");
	}
	
	public void setEng(Engine eng) {
		this.eng=eng;
		System.out.println("Setter() called");
	}
	
	public Car(Engine eng) {
		this.eng=eng;
		System.out.println("param con called");
	}
	
	public void revv() {
		boolean status=eng.startEngine();
		if(status) {
			System.out.println("Car is moving");
		}
		else {
			System.out.println("Engine problem");
		}
	}
}
