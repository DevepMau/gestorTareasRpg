package com.marcosm.gestortareasrpg.model;

public class ButtonModel {
	
	private final int DELAY_VALUE = 20;
	private boolean pressed;
	private boolean hovered;
	private boolean enable;
	private String text;
	private int timer; 
	
	public ButtonModel(String text) {
		
		this.setText(text);
		this.pressed = false;
		this.hovered = false;
		this.setTimer(DELAY_VALUE);
        this.setEnable(true);
		
	}
	
	public boolean isPressed() {
		return pressed;
	}

	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

	public boolean isHovered() {
		return hovered;
	}

	public void setHovered(boolean hovered) {
		this.hovered = hovered;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	public int getDelayValue() {
		return this.DELAY_VALUE;
	}


}
