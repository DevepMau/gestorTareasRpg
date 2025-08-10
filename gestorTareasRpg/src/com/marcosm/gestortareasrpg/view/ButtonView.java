package com.marcosm.gestortareasrpg.view;

import com.marcosm.gestortareasrpg.model.ButtonModel;
import java.awt.*;

public class ButtonView {
	
    private ButtonModel model;
	private int x; 
    private int y; 
    private int width; 
    private int height;

    public ButtonView(int x, int y, int width, int height, ButtonModel model) {
    	
        this.model = model;
    	this.x = x; 
        this.y = y;
        this.width = width; 
        this.height = height;
    }

    public void draw(Graphics2D g) {
    	
    	if (model.isPressed()) {
            g.setColor(Color.white);
        }
    	else if (model.isHovered()) {
            g.setColor(Color.LIGHT_GRAY);
        } 
        else {
            g.setColor(Color.GRAY);
        }
        
        g.fillRect(x, y, width, height);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);

        g.drawString(model.getText(), x + 10, y + (height / 2));
    }

    public boolean isMouseOver(int mouseX, int mouseY) {
    	
        return mouseX >= x && mouseX <= x + width &&
               mouseY >= y && mouseY <= y + height;
    }
}
