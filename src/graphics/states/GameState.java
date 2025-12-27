package graphics.states;

import java.awt.Color;
import java.awt.Graphics2D;

import audio.audioHandler.SoundEffects;
import graphics.layers.gameLayers.EntityLayer;
import graphics.layers.gameLayers.MapLayer;
import graphics.layers.gameLayers.ObjectLayer;
import graphics.layers.gameLayers.UILayer;
import main.Game;
import map.Tilemap;

public class GameState extends StateManager {
	
	private MapLayer mapLayer;
	private EntityLayer entityLayer;
	private ObjectLayer objectLayer;
	private UILayer uiLayer;
	
	public GameState(Game game) {
		super(game);
		
		SoundEffects.initSounds();
		
		mapLayer = new MapLayer(game);
		entityLayer = new EntityLayer(game);
		objectLayer = new ObjectLayer(game);
		uiLayer = new UILayer(game);
	}

	@Override
	public void update() {
		mapLayer.update();
		entityLayer.update();
		objectLayer.update();
		uiLayer.update();
	}

	@Override
	public void render(Graphics2D g2d) {
		mapLayer.render(g2d);
		entityLayer.render(g2d);
		objectLayer.render(g2d);
		uiLayer.render(g2d);
	}
}
