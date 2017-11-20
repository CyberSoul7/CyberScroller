package net.griscraft.cyberscroller.objects.enemies;

import net.griscraft.cyberscroller.Game;

public abstract class AI {
	
	protected final int health;
	protected final int speed;
	protected final Game game;
	
	public AI(int health, int speed, Game game) {
		this.health = health;
		this.speed = speed;
		this.game = game;
	}
	
	public abstract void tick(Enemy enemy);
	
}
