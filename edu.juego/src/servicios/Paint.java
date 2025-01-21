package servicios;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Paint extends JPanel{
	Rectangle playerPosition = new Rectangle(130,500,120,23);
	int numeroBloques  =30;
	ArrayList<Rectangle> bloques = new ArrayList<Rectangle>();
	Rectangle ballPosition = new Rectangle(400,200,23,23);
	
	
	
	@Override
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		 for (int i = 0; i < bloques.size(); i++) {
			 g.setColor(Color.BLUE);
		     g.fillRect(bloques.get(i).x, bloques.get(i).y, 60, 20);
		     g.setColor(Color.BLACK);
		     g.drawRect(bloques.get(i).x,bloques.get(i).y,60, 20);
		        
		 }
	       
	       g.setColor(Color.GREEN);
	       g.fillRect(playerPosition.x, playerPosition.y,120, 23);
	       g.setColor(Color.BLACK);
	       g.drawRect(playerPosition.x,playerPosition.y, 120, 23);
	        
	       g.setColor(Color.BLACK);
	       g.fillOval(ballPosition.x, ballPosition.y, 23,23);
	       
	 }
	
	public void movePlayer(int newx) {
		
		playerPosition.x += newx;
		if (playerPosition.x>=800-120) {
			playerPosition.x = 800-120;
			
		}else if (playerPosition.x<0) {
			playerPosition.x=0;
		
		}
		repaint();
	}
	
	
}
