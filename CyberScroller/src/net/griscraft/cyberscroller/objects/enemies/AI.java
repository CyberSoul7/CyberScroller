package net.griscraft.cyberscroller.objects.enemies;

public abstract class AI {
	
	protected final int health;
	protected final int speed;
	
	public AI(int health, int speed) {
		this.health = health;
		this.speed = speed;
	}
	
	public abstract void tick(Enemy enemy);
	
}
