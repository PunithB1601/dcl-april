package com.dcl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Bill {

	@Autowired
	private Payment payment;
	
	public Bill(Payment payment) {
		this.payment=payment;
		System.out.println("Param Bill");
	}
	
	public void setPayment(Payment payment) {
		this.payment=payment;
		System.out.println("setter() called");
	}
	
	public Bill() {
		System.out.println("0-param bill con");
	}
	
	void generateBill() {
		payment.doPayment();
		System.out.println("Bill Generated");
	}

}
