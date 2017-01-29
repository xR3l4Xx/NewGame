package window;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	private BufferedImage image;
	
	@SuppressWarnings("finally")
	public BufferedImage loadImage(String path, int scl){
		
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally{
			float w = scl * image.getWidth();
			float h = scl * image.getHeight();
			BufferedImage resizedImg = new BufferedImage((int)w, (int)h, BufferedImage.TRANSLUCENT);
		    Graphics2D g2 = resizedImg.createGraphics();
		    for(int x = 0; x < image.getWidth(); x++){
		    	for(int y = 0; y < image.getHeight(); y++){
		    		int clr = image.getRGB(x, y);
		    		Color c = new Color((clr & 0x00ff0000) >> 16, (clr & 0x0000ff00) >> 8, clr & 0x000000ff);
		    		g2.setColor(c);
		    		for(int i = 0; i < scl; i++){
		    			for(int j = 0; j < scl; j++){
		    				if(c.getRed() != 255 || c.getGreen() != 0 || c.getBlue() != 255){
		    					g2.fillRect((int)(x * scl + i), (int)(y * scl + j), 1, 1);
		    				}
		    			}
		    		}
		    	}
		    }
		    g2.dispose();
		    return resizedImg;
		}
		//return image;
	}
	
}
