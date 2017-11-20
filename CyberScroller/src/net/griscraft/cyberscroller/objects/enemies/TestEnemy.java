package net.griscraft.cyberscroller.objects.enemies;

import net.griscraft.cyberscroller.objects.enemies.WalkingAI.AttackStyle;

public class TestEnemy extends Enemy {
	
	public TestEnemy() {
		super(new WalkingAI(1, 1, AttackStyle.CLOSE));
	}
	
	
	
}
