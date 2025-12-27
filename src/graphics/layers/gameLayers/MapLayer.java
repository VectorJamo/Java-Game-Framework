package graphics.layers.gameLayers;

import java.awt.Graphics2D;

import graphics.layers.Layer;
import main.Game;
import map.Tilemap;

public class MapLayer extends Layer {
	
	public Tilemap map;

	public MapLayer(Game game) {
		super(game, "mapLayer");
		
		map = new Tilemap("res/maps/map.txt", "res/images/Terrain/Terrain.png", 16, 16);
		map.associateTileIdToSprite((short)7, 0, 7);
		map.associateTileIdToSprite((short)29, 1, 7);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics2D g2d) {
		map.render(g2d);
	}
}
