package com.marcosm.gestortareasrpg.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.marcosm.gestortareasrpg.utils.ImageUtils;

public class CustomCursorView {

    private Cursor cursorDefault;
    private Cursor cursorClick;

    public CustomCursorView() {
        loadCursorImages();
    }

    private void loadCursorImages() {
        try {
            BufferedImage handDefault = configureImage("/cursor/mano_default", 1);
            BufferedImage handClick = configureImage("/cursor/mano_click", 1);

            Point hotspot = new Point(0, 0);
            cursorDefault = Toolkit.getDefaultToolkit().createCustomCursor(handDefault, hotspot, "CursorNormal");
            cursorClick = Toolkit.getDefaultToolkit().createCustomCursor(handClick, hotspot, "CursorClick");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage configureImage(String rutaImagen, int escala) throws IOException {
        ImageUtils uTool = new ImageUtils();
        BufferedImage image = ImageIO.read(getClass().getResourceAsStream(rutaImagen + ".png"));
        return uTool.scaleImage(image, image.getWidth() / 2 * escala, image.getHeight() / 2 * escala);
    }

    public Cursor getCursorDefault() {
        return cursorDefault;
    }

    public Cursor getCursorClick() {
        return cursorClick;
    }
}
