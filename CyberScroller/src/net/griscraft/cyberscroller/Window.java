package net.griscraft.cyberscroller;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private static final long serialVersionUID = -5900069499824255582L;
	
	public Window(int width, int height, String title, Game game) {
		
		setTitle(title);
		setPreferredSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		setMinimumSize(new Dimension(width, height));
		
		add(game);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
}
