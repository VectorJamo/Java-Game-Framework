package graphics.textures;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {
	
	private BufferedImage image;
	
	public Texture(String filePath) {
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void render(Graphics2D g2d, int x, int y, int width, int height) {
		g2d.drawImage(image, x, y, width, height, null);
	}
	public BufferedImage getImage() {
		return image;
	}
}
