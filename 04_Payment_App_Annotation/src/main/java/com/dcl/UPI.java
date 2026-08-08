package com.dcl;

import org.springframework.stereotype.Component;

@Component("upi")
public class UPI implements Payment {

	public UPI() {
		System.out.println("UPI con");
	}

	@Override
	public void doPayment() {
		System.out.println("Payment done by UPI");
	}

}
