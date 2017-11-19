package net.griscraft.cyberscroller.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import net.griscraft.cyberscroller.Game;

public class Player extends GameObject {
	
	private boolean left = false, right = false;
	private boolean jumping = false;

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
		
		boolean topBlocks = false;
		
		for (GameObject object : handler.getObjects()) {
			
			if (!getBounds().intersects(object.getBounds())) continue;
			
			if (object instanceof Block) {
				
				Rectangle playerBounds = getBounds();
				Rectangle blockBounds = object.getBounds();
				
				if (playerBounds.y + playerBounds.height > blockBounds.y) {
					if (!jumping) {
						y -= velY;
					}
					topBlocks = true;
				}
				
			}
			
		}
		
		if (!topBlocks) {
			jumping = false;
		}
		
	}
	
	public void jump() {
		if (jumping) return;
		velY = -5;
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
	
	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

}
