package com.marcosm.gestortareasrpg.core;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UI {

	public BufferedImage escalarImagen(BufferedImage original, int ancho, int alto) {

		BufferedImage imagenEscalada = new BufferedImage(ancho, alto, original.getType());
		Graphics2D g2 = imagenEscalada.createGraphics();
		g2.drawImage(original, 0, 0, ancho, alto, null);
		g2.dispose();

		return imagenEscalada;

	}

}