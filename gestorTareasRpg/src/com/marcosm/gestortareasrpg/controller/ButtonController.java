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
    	
    	if(view.getButtonModel().isEnable()) {
    		onMouseClick(posX, posY, isClick);
    	}
    	else {
    		runTimerDelay();
    	}
    	
    }

    public void onMouseMove(int mouseX, int mouseY) {
    	
    	view.getButtonModel().setHovered(view.isMouseOver(mouseX, mouseY));
        
    }

    public void onMouseClick(int mouseX, int mouseY, boolean isClick) {
        if (view.isMouseOver(mouseX, mouseY)) {
        	if(isClick) {
        		view.getButtonModel().setPressed(true);
        		view.getButtonModel().setEnable(false);
                System.out.println("Botón presionado: " + view.getButtonModel().getText());
        	} 
        }
    }
    
    public void resetTimer() {
    	view.getButtonModel().setTimer(view.getButtonModel().getDelayValue());
    	view.getButtonModel().setEnable(true);
	}
    
    public void runTimerDelay() {
    	if(view.getButtonModel().getTimer() > 0) {
    		view.getButtonModel().setTimer(view.getButtonModel().getTimer() - 1);
    	}
    	else {
    		resetTimer();
    		view.getButtonModel().setPressed(false);
    	}
    }
}
