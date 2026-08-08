package com.dcl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CreditCard implements Payment {

	public CreditCard() {
		System.out.println("Credit Card con");
	}

	@Override
	public void doPayment() {
		System.out.println("Payment done by Credit Card");
	}

}
