package net.griscraft.cyberscroller.playerinput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import net.griscraft.cyberscroller.Game;

public class KeyInput extends KeyAdapter {
	
	Game game;
	
	public KeyInput(Game game) {
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
}
