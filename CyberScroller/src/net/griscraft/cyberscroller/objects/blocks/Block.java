package net.griscraft.cyberscroller.objects.blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import net.griscraft.cyberscroller.objects.GameObject;
import net.griscraft.cyberscroller.objects.ObjectHandler;

public abstract class Block extends GameObject {

	public Block(int x, int y, float terminalVelocity, ObjectHandler handler) {
		super(x, y, terminalVelocity, handler, false);
	}

	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
