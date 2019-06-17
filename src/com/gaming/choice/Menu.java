package com.gaming.choice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.gaming.choice.Game.STATE;

public class Menu extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx, my, 310, 150, 200, 64)) {
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2-35, Game.HEIGHT/2-32 , ID.Player, handler));
			//handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
		}
		
		if(mouseOver(mx, my, 210, 250, 200, 64)) {
			game.gameState = STATE.Tutorial;
		}
		
		if(mouseOver(mx, my, 210, 350, 200, 64)) {
			game.gameState = STATE.Menu;
			return;
		}
		
		if(mouseOver(mx, my, 310, 350, 200, 64)) {
			System.exit(1);
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		if(game.gameState == STATE.Menu) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Menu", 340, 70);
			
			g.setFont(fnt2);
			g.drawRect(310, 150, 200, 64);
			g.drawString("Play", 380, 190);
			
			g.drawString("Tutorial", 360, 290);
			g.drawRect(310, 250, 200, 64);
			
			g.drawString("Quit", 380, 390);
			g.drawRect(310, 350, 200, 64);
		}else if(game.gameState == STATE.Tutorial) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Tutorial", 330, 70);
			
			g.setFont(fnt2);
			g.drawString("Use WASD keys to move the player!", 170, 100);
			
			g.setFont(fnt2);
			g.drawString("Menu", 380, 390);
			g.drawRect(310, 350, 200, 64);
		}
		
	}

}
