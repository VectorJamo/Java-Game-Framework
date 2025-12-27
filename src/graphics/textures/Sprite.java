package graphics.textures;

import java.awt.Graphics2D;

import math.RectArea;

public class Sprite {
	private SpriteSheet spriteSheet;
	private int row, col;
	
	public Sprite(SpriteSheet spriteSheet, int row, int col) {
		this.spriteSheet = spriteSheet;
		this.row = row;
		this.col = col;
	}
	
	public void render(Graphics2D g2d, RectArea destination) {
		spriteSheet.renderSprite(g2d, row, col, destination);
	}
}
