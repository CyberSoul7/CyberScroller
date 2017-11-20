package net.griscraft.cyberscroller.objects.blocks;

import java.awt.Color;
import java.awt.Graphics;

import net.griscraft.cyberscroller.objects.ObjectHandler;

public class FloatingFloorBlock extends Block {

	public FloatingFloorBlock(int x, int y, float terminalVelocity, ObjectHandler handler) {
		super(x, y, terminalVelocity, handler);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int)x, (int)y, 32, 32);
	}

}
