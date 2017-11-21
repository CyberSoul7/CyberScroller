package net.griscraft.cyberscroller.objects.enemies;

import java.awt.Rectangle;

import net.griscraft.cyberscroller.Game;
import net.griscraft.cyberscroller.objects.Block;
import net.griscraft.cyberscroller.objects.GameObject;

public class WalkingAI extends AI {
	
	public enum AttackStyle {
		NONE,
		CLOSE,
		MEDIUM,
		SHOOT;
	}
	
	private int jumpHeight;
	private AttackStyle attack;
	private boolean left = false, right = true;
	private boolean jumping = false;
	private boolean topBlocks = false;
	
	public WalkingAI(int health, int speed, int jumpHeight, Game game, AttackStyle attack) {
		super(health, speed, game);
		this.attack = attack;
		this.jumpHeight = jumpHeight;
	}
	
	public void tick(Enemy enemy) {
		
		enemy.setX(enemy.getX() + enemy.getVelX());
		enemy.setY(enemy.getY() + enemy.getVelY());
		
		if (speed > 0 && enemy.getVelX() == 0) {
			 enemy.setVelX(speed);
		}
		
		collision(enemy);
		
	}
	
	public void collision(Enemy enemy) {
		
		topBlocks = false;
		
		for (GameObject object : enemy.getHandler().getObjects()) {
			
			if (!enemy.getBounds().intersects(object.getBounds())) continue;
			
			if (object instanceof Block) {
				
				Rectangle enemyBounds = enemy.getFullBounds();
				Rectangle blockBounds = object.getBounds();
				
				//Touching top of a block
				if (enemyBounds.y + enemyBounds.height > blockBounds.y && blockBounds.y + (blockBounds.height / 2) > enemyBounds.y + enemyBounds.height &&
						enemyBounds.x + enemyBounds.width > blockBounds.x && blockBounds.x + blockBounds.width > enemyBounds.x) {
					if (!jumping) {
						enemy.setY((int) enemy.getY() - (int) enemy.getVelY());
					}
					topBlocks = true;
					continue;
				}
				
				//Touching left of a block
				if (enemyBounds.x + enemyBounds.width > blockBounds.x && blockBounds.x + (blockBounds.width / 2) > enemyBounds.x + enemyBounds.width &&
						enemyBounds.y + enemyBounds.height > blockBounds.y && blockBounds.y + blockBounds.height > enemyBounds.y) {
					enemy.setVelX(-enemy.getVelX());
				}
				
				//Touching right of a block
				if (blockBounds.x + blockBounds.width > enemyBounds.x && enemyBounds.x > blockBounds.x + (blockBounds.width / 2) &&
						enemyBounds.y + enemyBounds.height > blockBounds.y && blockBounds.y + blockBounds.height > enemyBounds.y) {
					enemy.setVelX(-enemy.getVelX());
				}
				
			}
			
		}
		
		if (topBlocks) {
			jumping = false;
		}
		
	}
	
	public void jump(Enemy enemy) {
		enemy.setVelY(jumpHeight * 5);
	}

	public int getJumpHeight() {
		return jumpHeight;
	}

	public void setJumpHeight(short jumpHeight) {
		this.jumpHeight = jumpHeight;
	}

	public AttackStyle getAttack() {
		return attack;
	}

	public void setAttack(AttackStyle attack) {
		this.attack = attack;
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
