package com.marcosm.gestortareasrpg.controller;

import java.awt.event.*;
import com.marcosm.gestortareasrpg.view.CustomCursorView;
import com.marcosm.gestortareasrpg.view.GamePanel;

public class CustomCursorController implements MouseListener, MouseMotionListener {

    private GamePanel gp;
    private CustomCursorView cursorView;
    public int posX;
    public int posY;
    public boolean CLICK;

    public CustomCursorController(GamePanel gp, CustomCursorView cursorView) {
        this.gp = gp;
        this.cursorView = cursorView;
        gp.setCursor(cursorView.getCursorDefault());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        CLICK = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        CLICK = true;
        gp.setCursor(cursorView.getCursorClick());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        CLICK = false;
        gp.setCursor(cursorView.getCursorDefault());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Ratón salió de la ventana");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        posX = e.getX();
        posY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        gp.setCursor(cursorView.getCursorClick());
    }

    @Override
    public void mouseEntered(MouseEvent e) {}
}
