package com.dcl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("eng")
@Primary
public class Diesel implements Engine {

	public Diesel() {
		System.out.println("Diesel con called");
	}
	@Override
	public void start() {
		System.out.println("Diesel engine started");
	}

}
