package com.gaming.choice;
import java.awt.Color;
import java.awt.Graphics;
public class HUD {
	
	public static int HEALTH = 125;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 125);
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(15, 15, 250, 32);
		g.setColor(Color.GREEN);
		g.fillRect(15, 15, HEALTH * 2, 32);
		g.setColor(Color.WHITE);
		g.drawRect(15, 15, 250, 32);
	}
}
