package com.dcl;

import org.springframework.stereotype.Component;

@Component("payment")
public class DebitCard implements Payment {

	public DebitCard() {
		System.out.println("Debit Card con");
	}

	@Override
	public void doPayment() {
		System.out.println("Debit card payment done");
	}

}
