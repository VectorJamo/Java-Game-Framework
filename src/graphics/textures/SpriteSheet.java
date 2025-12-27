package graphics.textures;

import java.awt.Graphics2D;

import math.RectArea;

// A part of a texture
public class SpriteSheet {
	
	private Texture texture;
	private int spriteWidth, spriteHeight; // Size of a sprite
	
	public SpriteSheet(Texture texture, int spriteWidth, int spriteHeight) {
		this.texture = texture;
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
	}
	public SpriteSheet(String texturePath, int spriteWidth, int spriteHeight) {
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
		
		texture = new Texture(texturePath);
	}
	
	public void renderSprite(Graphics2D g2d, int row, int col, RectArea destination) {
		g2d.drawImage(texture.getImage(), destination.x, destination.y, destination.x+destination.width, destination.y+destination.height, 
				col*spriteWidth, row*spriteHeight, col*spriteWidth+spriteWidth, row*spriteHeight+spriteHeight, null);
	}
	
	public int getSpriteWidth() {
		return spriteWidth;
	}
	public int getSpriteHeight() {
		return spriteHeight;
	}
}
