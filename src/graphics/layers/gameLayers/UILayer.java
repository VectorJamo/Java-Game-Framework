package graphics.layers.gameLayers;

import java.awt.*;

import graphics.layers.Layer;
import main.Game;
import ui.UIManager;

public class UILayer extends Layer {
	
	public UILayer(Game game) {
		super(game, "uiLayer");
		
	}

	@Override
	public void update() {
		UIManager.update();
	}

	@Override
	public void render(Graphics2D g2d) {
	}
}
