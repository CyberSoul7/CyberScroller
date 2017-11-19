package net.griscraft.cyberscroller.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	public Player(int x, int y, ObjectHandler handler) {
		super(x, y, handler);
	}

	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 64);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 64);
	}

}
