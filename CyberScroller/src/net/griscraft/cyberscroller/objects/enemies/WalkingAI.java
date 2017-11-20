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
	
	public WalkingAI(int i, int j, AttackStyle attack) {
		super(i, j);
		this.attack = attack;
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
