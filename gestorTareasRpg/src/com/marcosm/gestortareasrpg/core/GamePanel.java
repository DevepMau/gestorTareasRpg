package com.marcosm.gestortareasrpg.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	
	// CONFIGURACIÓN DE PANTALLA
	final int originalTileSize = 16;
	final int scale = 3;

	public final int tileSize = originalTileSize * scale;
	public final int maxColScreen = 16;
	public final int maxRowScreen = 12;
	public final int screenWidth = tileSize * maxColScreen;
	public final int screenHeight = tileSize * maxRowScreen;
	
	//CONFIGURACION DEL MUNDO
	public final int maxColWorld = 16;
	public final int maxRowWorld = 12;
	public final int worldWidth = tileSize * maxColWorld;
	public final int worldHeight = tileSize * maxRowWorld;

	//SISTEMA
	public Keyboard keyboard = new Keyboard(this);
	Sound music = new Sound();
	Sound se = new Sound();
	UI ui = new UI();
	CustomCursor newCursor = new CustomCursor(this);
	Thread gameThread;
	
	//ENTIDADES Y OBJETOS

	//ESTADO DE JUEGO
	public int gameState;
	
	public final int GS_TITLE = 0;
	public final int GS_PLAY = 1;
	
	// FPS
	int FPS = 60;

	public GamePanel() {

		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyboard);
		this.setFocusable(true);
		this.addMouseListener(newCursor);
	    this.addMouseMotionListener(newCursor);

	}
	
	public void gameConfiguration() {
		gameState = GS_PLAY;
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();

	}
	
	public void playMusic(int i) {

		music.uploadFile(i);
		music.play();
		music.repeat();

	}

	public void stopMusic() {

		music.stop();

	}

	public void playSE(int i) {

		se.uploadFile(i);
		se.play();

	}

	@Override
	public void run() {

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while(gameThread != null) {

			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;

			if(delta >= 1) {
				update();
				repaint();
				delta--;
			}
		}

	}

	public void update() {

		if(gameState == GS_PLAY) {
			
		}
		if(gameState == GS_TITLE) {
			
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		//DEBUG
		long drawStart = 0;
		if(keyboard.checkDrawTime == true) {
			drawStart = System.nanoTime();
		}
		//PANTALLA DE TITULO
		if(gameState == GS_TITLE) {
		}
		//OTROS
		else {
			
		}

		//DEBUG
		if(keyboard.checkDrawTime == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("Draw Time: " + passed, 10, 400);
		}

		g2.dispose();

	}

}