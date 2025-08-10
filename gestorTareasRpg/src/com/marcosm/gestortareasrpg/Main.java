package com.marcosm.gestortareasrpg;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setTitle("Gestor Tareas RPG");

		GamePanel gp = new GamePanel();
		ventana.add(gp);

		ventana.pack();

		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

		gp.gameConfiguration();
		gp.startGameThread();

	}

}