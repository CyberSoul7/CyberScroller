package net.griscraft.cyberscroller.objects.enemies;

public abstract class AI {
	
	protected int health;
	protected int speed;
	
	public AI(int i, int j) {
		this.health = i;
		this.speed = j;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
