package Grafica;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import Entidad.Entidad;
import Logica.Juego;


import java.awt.Panel;


public class Gui extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JPanel panelNivel1; 
	private JLabel fondoNivel1;
	private Juego mijuego;
	private JLabel labelEntidad;
	private JLabel laberintoNivel1;
	private Panel panel;

	public Gui() {
	
		//Configuracion de la Ventana GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Images/icono.png")));
		setTitle("PACMAN 2.0");
		setSize(new Dimension(900, 600));
		setResizable(false);
		
	
		
		//Imagen del fondo de la Ventana Inicio
		String rutaFotoJuego =null;
		//if (mijuego.getNivel()==1)
				rutaFotoJuego=this.getClass().getResource("/Images/fondo_nivel1.png").toString();
		
		/*if (mijuego.getNivel()==2) {
			rutaFotoJuego = this.getClass().getResource("/Images/fondo_nivel2.png").toString();
		}
		if (mijuego.getNivel()==3) {
			 rutaFotoJuego = this.getClass().getResource("/Images/fondo_nivel3.png").toString();
		}*/
	    ImageIcon fotoJuego = null;
		try {
			fotoJuego = new ImageIcon(new URL(rutaFotoJuego));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaJuego = fotoJuego.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		getContentPane().setLayout(null);
		
		//panel del laberinto
		panelNivel1= new JPanel();
		//panelNivel1.setBounds(0, 0, 890, 561);
		panelNivel1.setBounds(0, 0, 900, 600);
		getContentPane().add(panelNivel1);
		panelNivel1.setVisible(true);
		
		
		//Crea el panel
		
		 panel = new Panel();
		panel.setBounds(197, 0, 501, 553);
		panelNivel1.add(panel);
		panel.setLayout(null);
		
		
		//Imagen del fondo del laberinto
		/*String rutaLaberinto = this.getClass().getResource("/Images/laberinto_nivel1.png").toString();
	    ImageIcon fotoLaberinto = null;
		try {
			fotoLaberinto = new ImageIcon(new URL(rutaLaberinto));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaLaberinto = fotoLaberinto.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
		panelNivel1.setLayout(null);
		
		laberintoNivel1 = new JLabel();
		laberintoNivel1.setBounds(0, 0, 491, 640);
		laberintoNivel1.setIcon(new ImageIcon(medidaLaberinto));
		panel.add(laberintoNivel1);
		*/
		
		//Label del fondo 
		fondoNivel1=new JLabel();
		fondoNivel1.setVerticalAlignment(SwingConstants.BOTTOM);
		fondoNivel1.setBounds(0, 0, 890, 561);
		panelNivel1.add(fondoNivel1);
		fondoNivel1.setBackground(Color.BLUE);
		fondoNivel1.setIcon(new ImageIcon(medidaJuego));
		fondoNivel1.setBackground(Color.BLUE);
		//mover esto
		
		   mijuego = new Juego(this);
		mijuego.iniciarJuego();
			
	}
	
	private class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if(mijuego.sigueEnJuego()) {
				 switch(e.getKeyCode()) {
	           /*  case KeyEvent.VK_LEFT: { mijuego.operar(Logica.moverIzquierda); break; }
	             case KeyEvent.VK_RIGHT: { mijuego.operar(Logica.moverDerecha); break; }
	             case KeyEvent.VK_UP: { mijuego.operar(Logica.rotar); break; }
	             case KeyEvent.VK_DOWN: { mijuego.operar(Logica.moverAbajo); break; }
	             */
	         	}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
	
	public void mostrarEntidad(Entidad e) {
		ImageIcon imagen=null;

		String rutaEntidad= e.getRepresentacionGrafica().getRuta();
			int ancho = e.getAncho();
			int alto = e.getAlto();
			labelEntidad = new JLabel();
			labelEntidad.setBounds(e.getPosicion().getX(), e.getPosicion().getY(), ancho, alto);
			try {
				imagen = new ImageIcon(new URL (rutaEntidad));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Image medidaEntidad = imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
			labelEntidad.setIcon(new ImageIcon(medidaEntidad)); 
			panel.add(labelEntidad);
			/*panelNivel1.add(labelEntidad);
			labelEntidad.setVisible(true);*/
			panel.repaint();
		
	}
		
	public void cambioPuntaje()  {
	
	}
    public void finDeJuego(){
	
	}
  
}