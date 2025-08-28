package com.marcosm.gestortareasrpg.controller;

import com.marcosm.gestortareasrpg.GamePanel;
import com.marcosm.gestortareasrpg.view.ButtonView;

public class ButtonController {
	
	GamePanel gp;
    private ButtonView view;

    public ButtonController(ButtonView view, GamePanel gp) {
    	
        this.gp = gp;
        this.view = view;
        
    }
    
    public void update() {
    	int posX = gp.newCursorController.posX;
    	int posY = gp.newCursorController.posY;
    	boolean isClick = gp.newCursorController.CLICK;
    	
    	onMouseMove(posX, posY);
    	
    	if(view.getBtnModel().isEnable()) {
    		onMouseClick(posX, posY, isClick);
    	}
    	else {
    		runTimerDelay();
    	}
    	
    }

    public void onMouseMove(int mouseX, int mouseY) {
    	
    	view.getBtnModel().setHovered(view.isMouseOver(mouseX, mouseY));
        
    }

    public void onMouseClick(int mouseX, int mouseY, boolean isClick) {
        if (view.isMouseOver(mouseX, mouseY)) {
        	if(isClick) {
        		view.getBtnModel().setPressed(true);
        		view.getBtnModel().setEnable(false);
                System.out.println("Botón presionado: " + view.getBtnModel().getText());
        	} 
        }
    }
    
    public void resetTimer() {
    	view.getBtnModel().setTimer(view.getBtnModel().getDelayValue());
    	view.getBtnModel().setEnable(true);
	}
    
    public void runTimerDelay() {
    	if(view.getBtnModel().getTimer() > 0) {
    		view.getBtnModel().setTimer(view.getBtnModel().getTimer() - 1);
    	}
    	else {
    		resetTimer();
    		view.getBtnModel().setPressed(false);
    	}
    }
}
