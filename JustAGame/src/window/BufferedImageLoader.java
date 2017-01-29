package window;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	private BufferedImage image;
	
	@SuppressWarnings("finally")
	public BufferedImage loadImage(String path, float scl){
		
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally{
			float w = scl * image.getWidth();
			float h = scl * image.getHeight();
			BufferedImage resizedImg = new BufferedImage((int)w, (int)h, BufferedImage.TRANSLUCENT);
		    Graphics2D g2 = resizedImg.createGraphics();
		    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    g2.drawImage(image, 0, 0, (int)w, (int)h, null);
		    g2.dispose();
		    return resizedImg;
		}
		//return image;
	}
	
}
