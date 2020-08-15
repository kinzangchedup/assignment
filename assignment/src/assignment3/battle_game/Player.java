package assignment3.battle_game;

public class Player {
	String name;
	int health, power;
	long startTime;
	long endTime;
	public Player(String name, int health, int power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	public Player() {
		this.name = "dummy"; 
		this.health = 0;
		this.power = 0;
	}
	public String toString() {
		return " "+((endTime-startTime)/1000000)+" milliseconds ";
	}
}
