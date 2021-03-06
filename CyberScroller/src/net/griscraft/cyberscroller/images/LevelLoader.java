package net.griscraft.cyberscroller.images;

import java.awt.image.BufferedImage;

import net.griscraft.cyberscroller.objects.*;
import net.griscraft.cyberscroller.objects.blocks.*;

public class LevelLoader {
	
	private BufferedImage level;
	private ObjectHandler handler;
	
	public LevelLoader(BufferedImage level, ObjectHandler handler) {
		this.level = level;
		this.handler = handler;
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
				
				if (red == 255 && blue == 0) {
					switch (green) {
					case 40:
						new FloatingFloorBlock(xx*32, yy*32, 0, handler).register();
						break;
					default:
						new FloorBlock(xx*32, yy*32, 0, handler).register();
						break;
					}
					
				}
				if (red == 0 && green == 0 && blue == 255) {
					if (player != null) {
						throw new InvalidLevelException("Too many Players!");
					}
					player = new Player(xx*32, yy*32 - 10, 5, handler);
				}
				
			}
		}
		
		if (player == null) {
			throw new InvalidLevelException("No player!");
		}
		
		return player;
		
	}
	
}
