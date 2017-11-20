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
			if (object.isGravityAffected()) object.applyGravity();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject object = objects.get(i);
			object.render(g);
		}
	}
	
	public List<GameObject> getObjects() {
		return objects;
	}
	
	public void addObject(GameObject object) {
		objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		objects.remove(object);
	}
	
	public void clearAll() {
		objects.clear();
	}
	
}
