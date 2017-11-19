package net.griscraft.cyberscroller.playerinput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import net.griscraft.cyberscroller.Game;
import net.griscraft.cyberscroller.objects.Player;

public class KeyInput extends KeyAdapter {
	
	Game game;
	
	public KeyInput(Game game) {
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		Player player = game.getPlayer();
		
		switch (key) {
		case KeyEvent.VK_W:
			player.setJumping(true);
			break;
		case KeyEvent.VK_A:
			player.setLeft(true);
			break;
		case KeyEvent.VK_D:
			player.setRight(true);
			break;
		case KeyEvent.VK_R:
			game.reloadLevel();
			break;
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		Player player = game.getPlayer();
		
		switch (key) {
		case KeyEvent.VK_A:
			player.setLeft(false);
			break;
		case KeyEvent.VK_D:
			player.setRight(false);
			break;
		}
	}
	
}
