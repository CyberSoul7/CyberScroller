package net.griscraft.cyberscroller.objects;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ObjectHandler {
	
	List<GameObject> objects = new ArrayList<GameObject>();
	
	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject object = objects.get(i);
			object.tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject object = objects.get(i);
			object.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		objects.remove(object);
	}
	
}
