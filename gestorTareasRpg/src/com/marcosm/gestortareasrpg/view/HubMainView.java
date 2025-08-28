package com.marcosm.gestortareasrpg.view;

import java.awt.Color;
import java.awt.Graphics2D;

import com.marcosm.gestortareasrpg.GamePanel;
import com.marcosm.gestortareasrpg.controller.ButtonController;
import com.marcosm.gestortareasrpg.model.ButtonModel;

public class HubMainView {
	
	GamePanel gp;
	private ButtonModel btnCreateModel;
	private ButtonModel btnDeleteModel;
	private ButtonView btnCreateView;
	private ButtonView btnDeleteView;

	
	public HubMainView(GamePanel gp) {
		
		this.gp = gp;
		createButtons(this.gp);
		
	}
	
	public void draw(Graphics2D g) {
		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, this.gp.screenWidth, this.gp.screenHeight);
		
		btnCreateView.draw(g);
		btnDeleteView.draw(g);
		
	}
	
	public ButtonView getBtnCreate() {
		
		return btnCreateView;
		
	}
	
	public ButtonView getBtnDelete() {
		
		return btnDeleteView;
		
	}
	
	
	private void createButtons(GamePanel gp) {
		
		int width = gp.tileSize*3;
		int height = gp.tileSize;
		int btnCreateX = gp.tileSize/2;
		int btnDeleteX = gp.tileSize*4;
		int btnPosY = gp.tileSize/2;
		
		btnCreateModel = new ButtonModel("Crear Mision");
		btnDeleteModel = new ButtonModel("Eliminar Mision");
		btnCreateView = new ButtonView(btnCreateX, btnPosY, width, height, btnCreateModel);
		btnDeleteView = new ButtonView(btnDeleteX, btnPosY, width, height, btnDeleteModel);
		
	}
	

}
