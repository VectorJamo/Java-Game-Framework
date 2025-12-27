package map;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import graphics.textures.Sprite;
import graphics.textures.SpriteSheet;
import math.RectArea;

public class Tilemap {
	private short[][] tileMap;
	private SpriteSheet worldSheet;
	private HashMap<Short, Sprite> tileIdToSprite = new HashMap<Short, Sprite>();
	
	public Tilemap(String filePath, String spriteTexturePath, int srcTileWidth, int srcTileHeight) {
		tileMap = new short[MapConstants.numWorldRows][MapConstants.numWorldCols];
		worldSheet = new SpriteSheet(spriteTexturePath, srcTileWidth, srcTileHeight);
		
		try {
			loadMap(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void associateTileIdToSprite(short tileID, int row, int col) {
		tileIdToSprite.put(tileID, new Sprite(worldSheet, row, col));
	}
	
	private void loadMap(String filePath) throws IOException {
		try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
			String line;
			int row = 0;
			int col = 0;
			while((line = fileReader.readLine()) != null) {
				String[] items = line.split(",");
				for(String item: items) {
					int tileID = Integer.parseInt(item);
					tileMap[row][col] = (short)tileID;
					col++;
				}
				col = 0;
				row++;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public void render(Graphics2D g2d) {
		for(int i = 0; i < MapConstants.numWorldRows; i++) {
			for(int j = 0; j < MapConstants.numWorldCols; j++) {
				int x = j*MapConstants.tileWidth;
				int y = i*MapConstants.tileHeight;
				
				short tileID = tileMap[i][j];
				if(tileIdToSprite.containsKey(tileID)) {
					RectArea destination = new RectArea(x, y, MapConstants.tileWidth, MapConstants.tileHeight);
					tileIdToSprite.get(tileID).render(g2d, destination);
				}
			}
		}
	}
}
