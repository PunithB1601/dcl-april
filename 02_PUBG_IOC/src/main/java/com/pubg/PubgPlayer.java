package com.pubg;

public class PubgPlayer {

	private Weapon weapon;
	
	public PubgPlayer() {
		System.out.println("0-param-PUBG con");
	}
	
	public PubgPlayer(Weapon weapon) {
		this.weapon=weapon;
		System.out.println("param-PUBG con");
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon=weapon;
		System.out.println("setter() called");
	}
	
	void killEnemy() {
		boolean kills=weapon.shoot();
		if(kills) {
			System.out.println("Enemy died");
		}
		else {
			System.out.println("Still alive");
		}
	}
}
