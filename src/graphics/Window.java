package graphics;

import javax.swing.JFrame;

import map.MapConstants;

public class Window extends JFrame {
	
	public static final int WIDTH = MapConstants.screenWidth;
	public static final int HEIGHT = MapConstants.screenHeight;
	public static final String TITLE = "Java Game Framework";
	
	public Window() {
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}
