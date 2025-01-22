package servicios;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDeJuego {
	int x1 = 130;
	int x2 = 80;
	int x = 10;
	int y = 10;
	int w = 25;
	int h = 15;
	int ballXDirection = 3;
    int ballYDirection = 3;
    int points = 0;
    int numVidas = 3;
    
	
  
	public void createWindow() {
		//Crear Ventana
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 600);
		window.setLocationRelativeTo(null);
		window.setLayout(new BorderLayout());
		
		
        
           
        


        
        
			
		
		//Crear bloques removibles
		Paint pintura = new Paint();
		
        for (int i = 0; i < 3; i++) { // 3 filas de bloques
            for (int j = 0; j < 10; j++) { // 10 bloques por fila
            	pintura.bloques.add(new Rectangle(40 + j * (60 + 10), 20 + i * ( 20+ 10),60,20));
            }
        }
 	    
 	
 	     
		//Crear y añadir Rectangulo
		Player player = new Player();
		window.add(pintura);
		//Movimiento de player
		 window.addKeyListener(new KeyListener() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                int key = e.getKeyCode(); // Código de la tecla presionada
	                switch (key) {
	                    case KeyEvent.VK_LEFT: // Flecha hacia la izquierda
	                        pintura.movePlayer(-30);
	                        break;
	                    case KeyEvent.VK_RIGHT: // Flecha hacia la derecha
	                        pintura.movePlayer(30);
	                        break;
	                }
	                
	            }

	            @Override
	            public void keyReleased(KeyEvent e) {
	                // No hacemos nada al liberar la tecla
	            }

	            @Override
	            public void keyTyped(KeyEvent e) {
	                // No hacemos nada al tipear
	            }
	        });
		 	JLabel puntos = new JLabel();
	        puntos.setText("Puntos: "+String.valueOf(points));
	        puntos.setBounds(550,750,50,50);
	        pintura.add(puntos);
	        JLabel vidas = new JLabel();
	        vidas.setText("Vidas: " + String.valueOf(numVidas));
	        pintura.add(vidas);
	        
	       
	       
		  // Hilo para mover la bola
		
	        new Thread(() -> {
	            while (true) {
	                pintura.ballPosition.x += ballXDirection;
	                pintura.ballPosition.y+= ballYDirection;
	                
	                
	                if (pintura.ballPosition.x <= 0 || pintura.ballPosition.x >= pintura.getWidth() - 30) {
	                    ballXDirection *= -1;
	                }
	                if (pintura.ballPosition.y <= 0) {
	                    ballYDirection *= -1;
	                }
	                if (pintura.ballPosition.y>=800 + 30) {
						pintura.ballPosition.x = 400;
						pintura.ballPosition.y = 300;
						points-= 5;
						numVidas -=1;
						vidas.setText("Vidas: " + String.valueOf(numVidas));
						puntos.setText("Puntos: "+String.valueOf(points));
					}
	                if (pintura.ballPosition.intersects(pintura.playerPosition)){
	                    ballYDirection *= -1;
	                    pintura.ballPosition.y = pintura.playerPosition.y - 30;
	                }
	                JLabel texto = new JLabel();
	    	        JPanel panel3 = new JPanel();
	    	        
	    	        if (numVidas==0) {
	      	        	 texto.setText("Has Perdido"); 
	      	        	 panel3.add(texto);
	      	        	 panel3.setVisible(true);
	      	        	 pintura.setVisible(false);
	      	        	 window.add(panel3);
	                   }
	    	      
	   	        
	                pintura.bloques.removeIf(block -> {
	                    if (pintura.ballPosition.intersects(block)) {
	                        ballYDirection *= -1;
	                        points += 10;
	                        puntos.setText("Puntos: "+String.valueOf(points));
	                        return true; // Eliminar bloque si hay colisión
	                    }
	                    return false;
	                });
	                
	                pintura.repaint();
	                try {
	                    Thread.sleep(10);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	            
	        }).start();
	        
	        pintura.setVisible(true);
	
	        
	        
	        
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		  
	    window.setVisible(true);
	        
	        
	        
	        
	        
		}
}

	

		

	
		

