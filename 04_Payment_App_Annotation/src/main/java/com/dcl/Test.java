package com.dcl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.NetBanking;

public class Test {

	public static void main(String[] args) {
		//IoC Container
		ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		NetBanking nb=context.getBean(NetBanking.class);
		nb.setAccountNumber(1001);
		System.out.println(nb.getAccountNumber());
		System.err.println("Program executed");
	}

}
