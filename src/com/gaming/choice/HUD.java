package com.gaming.choice;
import java.awt.Color;
import java.awt.Graphics;
public class HUD {
	
	public static int HEALTH = 125;
	private int greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 125);
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = HEALTH*2;
		
		score++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, 250, 24);
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(15, 15, HEALTH * 2, 24);
		g.setColor(Color.WHITE);
		g.drawRect(15, 15, 250, 24);
		
		g.drawString("Score: " + score, 15, 69);
		g.drawString("Level: " + level, 15, 55);
	}
	
	public void score(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public static void setHealth(int HEALTH) {
		HUD.HEALTH = HEALTH;
	}
}
