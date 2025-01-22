package servicios;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Player extends JPanel{
	int x1 =130 ;
	int x2 = 80; 
	int maxW = 800;
	int minW = 0;
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.GREEN);
			g.fillRect(x1, 400, x2, 20);
					
		}
			
		
	
	
		
	
	
}
