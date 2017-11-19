package net.griscraft.cyberscroller.images;

import java.awt.image.BufferedImage;

import net.griscraft.cyberscroller.objects.Block;
import net.griscraft.cyberscroller.objects.ObjectHandler;
import net.griscraft.cyberscroller.objects.Player;

public class LevelLoader {
	
	private BufferedImage level;
	private ObjectHandler handler;
	
	public LevelLoader(BufferedImage level, ObjectHandler handler) {
		this.level = level;
		this.handler = handler;
	}
	
	public Player load() {
		
		Player player;
		
		int w = level.getWidth();
		int h = level.getHeight();
		
		for (int xx = 0; xx < w; xx++) {
			for (int yy = 0; yy < h; yy++) {
				int pixel = level.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if (red == 255 && green == 0 && blue == 0) {
					handler.addObject(new Block(xx*32, yy*32));
				}
			}
		}
		
	}
	
}