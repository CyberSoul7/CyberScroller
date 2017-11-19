package net.griscraft.cyberscroller.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import net.griscraft.cyberscroller.Game;

public class Player extends GameObject {
	
	private boolean left = false, right = false;
	
	public Player(int x, int y, float terminalVelocity, ObjectHandler handler) {
		super(x, y, terminalVelocity, handler);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		collision();
		
		//Movement
		if (right) velX = 5;
		else if (!left) velX = 0;
		
		if (left) velX = -5;
		else if (!right) velX = 0;
		
		velY += Game.gravity;
		if (velY >= terminalVelocity) velY = terminalVelocity;
		
	}

	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int)x, (int)y, 32, 64);
	}
	
	public void collision() {
		
		for (GameObject object : handler.getObjects()) {
			if (!getBounds().intersects(object.getBounds())) continue;
			
			if (object instanceof Block) {
				y += velY * -1;
			}
			
		}
		
	}
	
	public void jump() {
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 64);
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
