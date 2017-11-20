package net.griscraft.cyberscroller.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import net.griscraft.cyberscroller.objects.blocks.Block;
import net.griscraft.cyberscroller.objects.blocks.FloatingFloorBlock;

public class Player extends GameObject {
	
	private boolean left = false, right = false;
	private boolean jumping = false;
	private boolean topBlocks = false;

	public Player(int x, int y, float terminalVelocity, ObjectHandler handler) {
		super(x, y, terminalVelocity, handler, true);
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
				if (playerBounds.y + playerBounds.height > blockBounds.y && blockBounds.y + (blockBounds.height / 2) > playerBounds.y + playerBounds.height &&
						playerBounds.x + playerBounds.width > blockBounds.x && blockBounds.x + blockBounds.width > playerBounds.x) {
					if (!jumping) {
						y -= velY;
					}
					topBlocks = true;
					continue;
				}
				
				//Don't rest of collision tests if it is a FloatingFloorBlock
				if (object instanceof FloatingFloorBlock) continue;
				
				//Touching bottom of a block
				if (blockBounds.y + blockBounds.height > playerBounds.y && playerBounds.y > blockBounds.y + (blockBounds.height / 2) &&
						playerBounds.x + playerBounds.width > blockBounds.x && blockBounds.x + blockBounds.width > playerBounds.x) {
					y -= velY;
				}
				
				//Touching left of a block
				if (playerBounds.x + playerBounds.width > blockBounds.x && blockBounds.x + (blockBounds.width / 2) > playerBounds.x + playerBounds.width &&
						playerBounds.y + playerBounds.height > blockBounds.y && blockBounds.y + blockBounds.height > playerBounds.y) {
					x += velX * -1;
				}
				
				//Touching right of a block
				if (blockBounds.x + blockBounds.width > playerBounds.x && playerBounds.x > blockBounds.x + (blockBounds.width / 2) &&
						playerBounds.y + playerBounds.height > blockBounds.y && blockBounds.y + blockBounds.height > playerBounds.y) {
					x += velX * -1;
				}
				
				
			}
			
		}
		
		if (topBlocks) {
			jumping = false;
		}
		
	}
	
	private void jump() {
		velY = -10;
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
