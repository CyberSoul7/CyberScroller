package net.griscraft.cyberscroller.objects.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import net.griscraft.cyberscroller.objects.ObjectHandler;
import net.griscraft.cyberscroller.objects.enemies.WalkingAI.AttackStyle;

public class TestEnemy extends Enemy {
	
	public TestEnemy(int x, int y, float terminalVelocity, ObjectHandler handler) {
		super(x, y, terminalVelocity, handler, new WalkingAI(1, 1, AttackStyle.CLOSE));
	}

	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int)x, (int)y, 32, 32);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x+5, (int)y+5, 22, 22);
	}
	
	
	
}
