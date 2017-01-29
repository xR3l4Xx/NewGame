package window;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	private BufferedImage image;
	
	@SuppressWarnings("finally")
	public BufferedImage loadImage(String path){
		
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally{
			return image;
		}
		//return image;
	}
	
}
