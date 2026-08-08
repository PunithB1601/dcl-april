package com.pubg;

public class AKM implements Weapon {

	public AKM() {
		System.out.println("AKM con");
	}
	@Override
	public boolean shoot() {
		System.out.println("Enemy shot by AKM");
		return true;
	}

}
