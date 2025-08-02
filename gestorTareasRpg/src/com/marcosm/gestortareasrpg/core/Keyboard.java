package com.marcosm.gestortareasrpg.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	GamePanel gp;
	public boolean W, S, A, D, ENTER, ESCAPE;
	//DEBUG
	boolean checkDrawTime = false;
	
	public Keyboard(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int codigo = e.getKeyCode();
		
		//MODO JUEGO
		if(gp.gameState == gp.GS_PLAY) {
			
			if(codigo == KeyEvent.VK_W) {
				W = true;
			}
			if(codigo == KeyEvent.VK_S) {
				S = true;
			}
			if(codigo == KeyEvent.VK_A) {
				A = true;
			}
			if(codigo == KeyEvent.VK_D) {
				D = true;
			}
			if(codigo == KeyEvent.VK_P) {
				//PAUSA SI ES NECESARIO
			}
			if(codigo == KeyEvent.VK_ENTER) {
				ENTER = true;
			}
			if(codigo == KeyEvent.VK_ESCAPE) {
				ESCAPE = true;
			}
			//MODO DEBUG
			if(codigo == KeyEvent.VK_T) {
				if(checkDrawTime == false) {
					checkDrawTime = true;
				}
				else if(checkDrawTime == true) {
					checkDrawTime = false;
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int codigo = e.getKeyCode();

		if(codigo == KeyEvent.VK_W) {
			W = false;
		}
		if(codigo == KeyEvent.VK_S) {
			S = false;
		}
		if(codigo == KeyEvent.VK_A) {
			A = false;
		}
		if(codigo == KeyEvent.VK_D) {
			D = false;
		}
		if(codigo == KeyEvent.VK_ENTER) {
			ENTER = false;
		}
		if(codigo == KeyEvent.VK_ESCAPE) {
			ESCAPE = false;
		}


	}

}