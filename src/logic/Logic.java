package logic;

import java.awt.Color;

import javax.swing.JButton;

public class Logic {

	public void drawLine(int x0, int y0, int x1, int y1, JButton[][] grid) {
		int deltaX = x1 - x0;
		int deltaY = y1 - y0;
		int pasos = Math.abs(deltaX) > Math.abs(deltaY) ? Math.abs(deltaX)
				: Math.abs(deltaY);
		double xIncremento = (double) deltaX / (double) pasos;
		double yIncremento = (double) deltaY / (double) pasos;
		double x = x0;
		double y = y0;
		grid[y0][x0].setBackground(Color.BLACK);
		grid[y1][x1].setBackground(Color.BLACK);
		for (int i = 1; i < pasos; i++) {
			x += xIncremento;
			y += yIncremento;
			grid[(int) y][(int) x].setBackground(Color.BLACK);
		}
	}
}
