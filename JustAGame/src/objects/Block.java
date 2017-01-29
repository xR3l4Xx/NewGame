package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import framework.GameObject;
import framework.ObjectId;
import window.BufferedImageLoader;

public class Block extends GameObject {

	public Block(float x, float y, ObjectId id) {
		super(x, y, id);
		BufferedImageLoader loader = new BufferedImageLoader();
		texture = loader.loadImage("/wall.png", 4);
	}

	public void tick(LinkedList<GameObject> object) {
		
	}

	public void render(Graphics g)
	{
		if(texture==null){
			g.setColor(Color.WHITE);
			g.drawRect((int)x, (int)y, 32, 32);
		}else{
			g.drawImage(texture, (int)x, (int)y, null);
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}

}
