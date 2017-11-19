package net.griscraft.cyberscroller.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	private boolean left = false, right = false;
	
	public Player(int x, int y, ObjectHandler handler) {
		super(x, y, handler);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//Movement
		if (right) velX = 5;
		else if (!left) velX = 0;
		
		if (left) velX = -5;
		else if (!right) velX = 0;
		
	}

	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 64);
	}
	
	public void jump() {
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 64);
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

}
