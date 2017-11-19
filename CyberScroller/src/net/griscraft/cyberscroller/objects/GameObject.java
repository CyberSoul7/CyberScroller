package net.griscraft.cyberscroller.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected float x, y;
	protected float velX = 0, velY = 0;
	protected ObjectHandler handler;
	protected float terminalVelocity;
	
	public GameObject(int x, int y, float terminalVelocity, ObjectHandler handler) {
		this.x = x;
		this.y = y;
		this.handler = handler;
		this.terminalVelocity = terminalVelocity;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void register() {
		handler.addObject(this);
	}
	
	public boolean unregister() {
		if (handler.objects.contains(this)) {
			handler.removeObject(this);
			return true;
		}
		return false;
	}

	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
	
}
