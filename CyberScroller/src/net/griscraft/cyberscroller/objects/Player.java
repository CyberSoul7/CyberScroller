package net.griscraft.cyberscroller.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import net.griscraft.cyberscroller.Game;

public class Player extends GameObject {
	
	private boolean left = false, right = false;
	private boolean jumping = false;
	private boolean topBlocks = false;

	public Player(int x, int y, float terminalVelocity, ObjectHandler handler) {
		super(x, y, terminalVelocity, handler);
	}

	public void tick() {
		if (jumping && topBlocks) {
			jump();
		}
		
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
	
	private void collision() {
		
		topBlocks = false;
		
		for (GameObject object : handler.getObjects()) {
			
			if (!getBounds().intersects(object.getBounds())) continue;
			
			if (object instanceof Block) {
				
				Rectangle playerBounds = getBounds();
				Rectangle blockBounds = object.getBounds();
				
				//Touching top of a block
				if (playerBounds.y + playerBounds.height > blockBounds.y &&
						playerBounds.x + playerBounds.width > blockBounds.x && blockBounds.x + blockBounds.width > playerBounds.x) {
					if (!jumping) {
						y -= velY;
					}
					topBlocks = true;
				}
				
				//Touching bottom of a block
				if (blockBounds.y + blockBounds.height > playerBounds.y &&
						playerBounds.x + playerBounds.width > blockBounds.x && blockBounds.x + blockBounds.width > playerBounds.x) {
					velY *= -1;
				}
				
				//Touching left of a block
				if (blockBounds.x)
				
			}
			
		}
		
		if (topBlocks) {
			jumping = false;
		}
		
	}
	
	private void jump() {
		velY = -7;
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
