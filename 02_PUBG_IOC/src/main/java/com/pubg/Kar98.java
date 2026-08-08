package com.pubg;

public class Kar98 implements Weapon{

	public Kar98() {
		System.out.println("Kar98 con");
	}
	@Override
	public boolean shoot() {
		System.out.println("Head shot by Kar98");
		return true;
	}

}
