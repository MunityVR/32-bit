package com.gaming.choice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class OOFEnemy extends GameObject {
	
	private Handler handler;
	
	public OOFEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 8;
		velY = 8;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.DARK_GRAY, 16, 16, 0.04f, handler));
	}

	
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, 16, 16);
		
	}

}
