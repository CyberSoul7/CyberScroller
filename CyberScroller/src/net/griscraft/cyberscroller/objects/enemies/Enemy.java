package net.griscraft.cyberscroller.objects.enemies;

import net.griscraft.cyberscroller.objects.GameObject;
import net.griscraft.cyberscroller.objects.ObjectHandler;

public abstract class Enemy extends GameObject {
	
	protected AI ai;
	protected int health;
	
	public Enemy(int x, int y, float terminalVelocity, ObjectHandler handler, AI ai) {
		super(x, y, terminalVelocity, handler, true);
		this.ai = ai;
		switch (ai.health) {
		case 1:
			health = 10;
			break;
		case 3:
			health = 50;
			break;
		case 5:
			health = 100;
			break;
		default:
			health = 100;
			break;
		}
	}
	
	public void tick() {
		ai.tick(this);
	}
	
	public void takeDamage(int damageAmount) {
		health -= damageAmount;
	}
	
}
