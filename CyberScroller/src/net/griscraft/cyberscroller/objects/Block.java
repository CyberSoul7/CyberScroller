package net.griscraft.cyberscroller.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends GameObject {

	public Block(int x, int y, float terminalVelocity, ObjectHandler handler) {
		super(x, y, terminalVelocity, handler);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
