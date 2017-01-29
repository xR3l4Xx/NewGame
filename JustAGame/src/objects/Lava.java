package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import framework.GameObject;
import framework.ObjectId;
import window.BufferedImageLoader;

public class Lava extends GameObject{

	public Lava(float x, float y, ObjectId id) {
		super(x, y, id);
		BufferedImageLoader loader = new BufferedImageLoader();
		texture = loader.loadImage("/lava.png", 4);
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
	}

	@Override
	public void render(Graphics g) {
		if(texture==null){
			g.setColor(Color.cyan);
			g.drawRect((int)x, (int)y, 32, 32);
		}else{
			g.drawImage(texture, (int)x, (int)y, null);
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	
}
