package com.pubg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		PubgPlayer p1=context.getBean(PubgPlayer.class);
		PubgPlayer p2=context.getBean(PubgPlayer.class);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}
}
