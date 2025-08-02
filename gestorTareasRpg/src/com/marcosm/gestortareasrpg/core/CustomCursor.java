package com.marcosm.gestortareasrpg.core;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.marcosm.gestortareasrpg.utils.ImageUtils;

public class CustomCursor implements MouseListener, MouseMotionListener {

	GamePanel gp;
	private Cursor cursorDefault;
	private Cursor cursorClick;
	private BufferedImage handDefault, handClick;
	public int posX;
	public int posY;
	public boolean CLICK;

    public CustomCursor(GamePanel gp) {
		this.gp = gp;
		
		getCursorImage();
		
		Point hotspot = new Point(0, 0);
        cursorDefault = Toolkit.getDefaultToolkit().createCustomCursor(handDefault, hotspot, "CursorNormal");
        cursorClick = Toolkit.getDefaultToolkit().createCustomCursor(handClick, hotspot, "CursorClick");
	
        gp.setCursor(cursorDefault);
    }

	@Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Clic en: (" + e.getX() + ", " + e.getY() + ")");
    	CLICK = true;
    }

	@Override
	public void mousePressed(MouseEvent e) {
	    CLICK = true;
	    gp.setCursor(cursorClick);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	    CLICK = false;
	    gp.setCursor(cursorDefault);
	}

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Ratón salió de la ventana");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("Ratón movido a: (" + e.getX() + ", " + e.getY() + ")");
        posX = e.getX();
        posY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("Arrastrando el ratón a: (" + e.getX() + ", " + e.getY() + ")");
    	gp.setCursor(cursorClick);
    }
    
    public void getCursorImage() {
    	try {
    		handDefault = configureImage("/cursor/mano_default", 1);
    		handClick = configureImage("/cursor/mano_click", 1);
    	} catch (IOException e) {
 			e.printStackTrace();
 		}
    }
    
    ////////////////////////////////////////////////////////////////////////////////////
    
    private BufferedImage configureImage(String rutaImagen, int escala) throws IOException {
        ImageUtils uTool = new ImageUtils();
        BufferedImage image = ImageIO.read(getClass().getResourceAsStream(rutaImagen + ".png"));
        return uTool.scaleImage(image, image.getWidth() / 2 * escala, image.getHeight() / 2 * escala);
    }

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}