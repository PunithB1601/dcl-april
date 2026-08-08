package com.dcl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//to start IoC container
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Car c1=context.getBean(Car.class);
		System.out.println(c1);
		Car c2=context.getBean(Car.class);
		System.out.println(c2);
	}
}
