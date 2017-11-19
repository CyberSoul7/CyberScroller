package net.griscraft.cyberscroller;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import net.griscraft.cyberscroller.objects.ObjectHandler;
import net.griscraft.cyberscroller.objects.Player;
import net.griscraft.cyberscroller.playerinput.KeyInput;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 212029454656049370L;
	
	public static final int width = 1000, height = 563;
	
	private boolean isRunning = false;
	private Thread thread;
	private ObjectHandler handler;
	
	private Player player;
	
	private int fps;
	
	public Game() {
		new Window(width, height, "CyberScroller", this);
		
		handler = new ObjectHandler();
		player = new Player(40, 40, handler);
		player.register();
		
		this.addKeyListener(new KeyInput(this));
		
		start();
	}
	
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				fps = frames;
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		/*Start Drawing*/
		
		//Background
		g.setColor(Color.RED);
		g.fillRect(0, 0, width, height);
		
		//Objects
		handler.render(g);
		
		/*Stop Drawing*/
		
		g.dispose();
		bs.show();
		
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
