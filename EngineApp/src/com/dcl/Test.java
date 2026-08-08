package com.dcl;

public class Test {
 public static void main(String[] args) {
	
	 System.out.println("---constructor injection---");
	Petrol p=new Petrol();
	Car c1=new Car(p);
	c1.revv();
	
	System.out.println("---Setter Injection---");
	Diesel d=new Diesel();
	Car c2=new Car();
	c2.setEng(d);
	c2.revv();
	
	System.out.println("---Field Injection---");
	Car c3=new Car();
	c3.eng=new Petrol();
	c3.revv();
	
	
	
}
 
}
