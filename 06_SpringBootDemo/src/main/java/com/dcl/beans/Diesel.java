package com.dcl.beans;

import org.springframework.stereotype.Component;


public class Diesel implements Engine{
	
	public Diesel() {
		System.out.println("diesel con");
	}

	@Override
	public void start() {
		System.out.println("Diesel engine");
	}

}
