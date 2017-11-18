package net.griscraft.cyberscroller;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 212029454656049370L;
	
	public static final int width = 1000, height = 563;
	
	public Game() {
		new Window(width, height, "CyberScroller", this);
	}
	
	public void run() {
		
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
