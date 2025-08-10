package com.marcosm.gestortareasrpg.controller;

import com.marcosm.gestortareasrpg.GamePanel;
import com.marcosm.gestortareasrpg.model.ButtonModel;
import com.marcosm.gestortareasrpg.view.ButtonView;

public class ButtonController {
	
	GamePanel gp;
	private ButtonModel model;
    private ButtonView view;

    public ButtonController(ButtonModel model, ButtonView view, GamePanel gp) {
    	
        this.gp = gp;
    	this.model = model;
        this.view = view;
        
    }
    
    public void update() {
    	int posX = gp.newCursorController.posX;
    	int posY = gp.newCursorController.posY;
    	boolean isClick = gp.newCursorController.CLICK;
    	
    	onMouseMove(posX, posY);
    	
    	if(model.isEnable()) {
    		onMouseClick(posX, posY, isClick);
    	}
    	else {
    		runTimerDelay();
    	}
    	
    }

    public void onMouseMove(int mouseX, int mouseY) {
    	
        model.setHovered(view.isMouseOver(mouseX, mouseY));
        
    }

    public void onMouseClick(int mouseX, int mouseY, boolean isClick) {
        if (view.isMouseOver(mouseX, mouseY)) {
        	if(isClick) {
        		model.setPressed(true);
        		model.setEnable(false);
                System.out.println("Botón presionado: " + model.getText());
        	} 
        }
    }
    
    public void resetTimer() {
		model.setTimer(model.getDelayValue());
		model.setEnable(true);
	}
    
    public void runTimerDelay() {
    	if(model.getTimer() > 0) {
    		model.setTimer(model.getTimer() - 1);
    	}
    	else {
    		resetTimer();
    		model.setPressed(false);
    	}
    }
}
