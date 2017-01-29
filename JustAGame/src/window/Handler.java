package window;
import java.awt.Graphics;
import java.util.LinkedList;

import objects.Block;
import framework.GameObject;
import framework.ObjectId;


public class Handler
{
	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public GameObject tempObject;
	
	public void tick(){
		for(int i = 0; i < object.size(); i++)
		{
			tempObject = object.get(i);
			
			tempObject.tick(object);
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++)
		{
			tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	public void createLevel()
	{
		for(int xx = 0; xx < Game.WIDTH+32;xx+=32){
			addObject(new Block(xx,Game.HEIGHT-32,ObjectId.Block));
		}
		
		for(int yy = Game.HEIGHT-64; yy > -32;yy-=32){
			addObject(new Block(0,yy,ObjectId.Block));
			addObject(new Block(Game.WIDTH-32,yy,ObjectId.Block));
		}
		int mid = Game.WIDTH/2;
		for(int i = 0; i<7; i++){
			addObject(new Block(mid-i*32,256,ObjectId.Block));
		}
	}
	
}
