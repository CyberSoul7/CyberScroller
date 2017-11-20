package net.griscraft.cyberscroller.images;

import java.awt.image.BufferedImage;

import net.griscraft.cyberscroller.Game;
import net.griscraft.cyberscroller.objects.Block;
import net.griscraft.cyberscroller.objects.Player;
import net.griscraft.cyberscroller.objects.enemies.TestEnemy;

public class LevelLoader {
	
	private BufferedImage level;
	private Game game;
	
	public LevelLoader(BufferedImage level, Game game) {
		this.level = level;
		this.game = game;
	}
	
	public Player load() throws InvalidLevelException {
		
		Player player = null;
		
		int w = level.getWidth();
		int h = level.getHeight();
		
		for (int xx = 0; xx < w; xx++) {
			for (int yy = 0; yy < h; yy++) {
				int pixel = level.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if (red == 255 && green == 0 && blue == 0) {
					new Block(xx*32, yy*32, 0, game.getHandler()).register();
				}
				if (red == 0 && green == 0 && blue == 255) {
					if (player != null) {
						throw new InvalidLevelException("Too many Players!");
					}
					player = new Player(xx*32, yy*32 - 10, 5, game.getHandler());
				}
				if (red == 0 && green == 255 && blue == 0) {
					new TestEnemy(xx*32, yy*32, 5, game.getHandler(), game).register();
				}
				
			}
		}
		
		if (player == null) {
			throw new InvalidLevelException("No player!");
		}
		
		return player;
		
	}
	
}
