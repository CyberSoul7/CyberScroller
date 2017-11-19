package net.griscraft.cyberscroller.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int x, y;
	protected float velX = 0, velY = 0;
	protected ObjectHandler handler;
	
	public GameObject(int x, int y, ObjectHandler handler) {
		this.x = x;
		this.y = y;
		this.handler = handler;
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
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
