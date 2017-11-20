package net.griscraft.cyberscroller.objects.enemies;

public class WalkingAI extends AI {
	
	public enum AttackStyle {
		NONE,
		CLOSE,
		MEDIUM,
		SHOOT;
	}
	
	private short jumpHeight;
	private AttackStyle attack;
	
	public WalkingAI(int speed, int health, AttackStyle attack) {
		super(speed, health);
		this.attack = attack;
	}
	
	public void tick(Enemy enemy) {
		
		
		
	}
	
	

	public short getJumpHeight() {
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

}
