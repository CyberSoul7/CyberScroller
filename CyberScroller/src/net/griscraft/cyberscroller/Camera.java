package net.griscraft.cyberscroller;

import net.griscraft.cyberscroller.objects.GameObject;

public class Camera {
	
	private float x, y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick(GameObject object) {
		
		x += ((object.getX() - x) - Game.width / 2) * 0.05f;
		y += ((object.getY() - y) - Game.height / 2) * 0.05;
		
		if (x <= 0) x = 0;
		if (y <= 0) y = 0;
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
