package framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import window.Handler;

public class KeyInput extends KeyAdapter
{	
	Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;	
	}
	
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player){
				if(key == KeyEvent.VK_D) tempObject.setVelX(10);
				if(key == KeyEvent.VK_A) tempObject.setVelX(-10);
				if(key == KeyEvent.VK_W && !tempObject.isJumping())
				{
					tempObject.setJumping(true);
					tempObject.setVelY(-18);
				}
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player){
				if(key == KeyEvent.VK_D)
					if(tempObject.getVelX() > 0)
					tempObject.setVelX(0);
				if(key == KeyEvent.VK_A)
					if(tempObject.getVelX() < 0)
					tempObject.setVelX(0);
			}
		}
	}
}
