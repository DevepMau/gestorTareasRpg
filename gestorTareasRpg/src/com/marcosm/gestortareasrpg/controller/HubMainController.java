package com.marcosm.gestortareasrpg.controller;

import java.awt.Graphics2D;

import com.marcosm.gestortareasrpg.GamePanel;
import com.marcosm.gestortareasrpg.view.HubMainView;

public class HubMainController {

	GamePanel gp;
	private HubMainView hubView;
	private ButtonController btnCreate;
	private ButtonController btnDelete;
	
	public HubMainController(HubMainView hubView, GamePanel gp) {
		
		this.gp = gp;
		this.hubView = hubView;
		btnCreate = new ButtonController(hubView.getBtnCreate(), this.gp);
		btnDelete = new ButtonController(hubView.getBtnDelete(), this.gp);
		
	}
	
	public void update() {
		
		btnCreate.update();
		btnDelete.update();
			
	}
	
	public void draw(Graphics2D g) {
		
		hubView.draw(g);
		
	}

}