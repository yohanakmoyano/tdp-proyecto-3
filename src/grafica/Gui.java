package grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.SwingConstants;
import entidades.Entidad;
import logica.Juego;
import javax.swing.JTextField;


public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelprincipal;
	private JPanel laberinto;
	
	private Juego mijuego;
	//private JLabel labelEntidad;
	private JLabel fondoNivel;
	private JTextField text_puntaje;
	private JTextField text_vidas;

	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Images/generales/icono.png")));
		setTitle("PACMAN 2.0");
		setSize(new Dimension(900, 600));
		setResizable(false);

		//Panel principal
		panelprincipal = new JPanel();
		panelprincipal.setBounds(0, 0, 900, 600);
		getContentPane().add(panelprincipal);
		panelprincipal.setVisible(true);
		panelprincipal.setLayout(null);
		
		//Text Puntaje
		text_puntaje = new JTextField();
		text_puntaje.setForeground(Color.WHITE);
		text_puntaje.setBackground(Color.DARK_GRAY);
		text_puntaje.setText("0");
		text_puntaje.setEditable(false);
		text_puntaje.setFont(new Font("Consolas", Font.BOLD, 22));
		text_puntaje.setBounds(725, 56, 137, 27);
		panelprincipal.add(text_puntaje);
		text_puntaje.setColumns(10);
		
		//Text Vidas
		text_vidas = new JTextField();
		text_vidas.setForeground(Color.WHITE);
		text_vidas.setBackground(Color.DARK_GRAY);
		text_vidas.setEditable(false);
		text_vidas.setColumns(10);
		text_vidas.setFont(new Font("Consolas", Font.BOLD, 22));
		text_vidas.setBounds(725, 140, 137, 27);
		panelprincipal.add(text_vidas);
		
		//Panel laberinto
		laberinto = new JPanel();
		laberinto.setBounds(197, 0, 501, 553);
		panelprincipal.add(laberinto);
		laberinto.setLayout(new GridLayout(20, 20, 0, 0));
		laberinto.setVisible(true);
		laberinto.setLayout(null);
		laberinto.setBackground(Color.black);
		
		//Inicia miJuego
		mijuego = new Juego(this);
		mijuego.iniciarJuego();
		//Oyentes de teclados
		KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		setFocusable(true);
		getContentPane().setLayout(null);
		
	}
	
	public void actualizarPuntaje() {
		text_puntaje.setText(" "+mijuego.getPuntaje());
	}
	
	public void actualizarVidas(int v) {
		text_vidas.setText(" "+v);
	}
	
	public void mostrarImagenFondo(String s) {
		ImageIcon fotoJuego = null;
		try {
			fotoJuego = new ImageIcon(new URL(s));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Image medidaJuego = fotoJuego.getImage().getScaledInstance(890, 600, Image.SCALE_DEFAULT);
		getContentPane().setLayout(null);
		fondoNivel = new JLabel();
		fondoNivel.setVerticalAlignment(SwingConstants.BOTTOM);
		fondoNivel.setBounds(0, 0, 900, 600);
		panelprincipal.add(fondoNivel);
		fondoNivel.setIcon(new ImageIcon(medidaJuego));;
	}
	
	//Comentado temporalmente
	/*
	public void mostrarEntidad(Entidad e) {
		ImageIcon imagen = null;
		String rutaEntidad = e.getRepresentacionGrafica().getRuta();
		int ancho = e.getAncho();
		int alto = e.getAlto();
		labelEntidad = new JLabel();
		labelEntidad.setBounds(e.getPosicion().getX(), e.getPosicion().getY(), ancho, alto);
		try {
			imagen = new ImageIcon(new URL(rutaEntidad));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		Image medidaEntidad = imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
		labelEntidad.setIcon(new ImageIcon(medidaEntidad));
		laberinto.add(labelEntidad);
		labelEntidad.setVisible(true);

	}*/
	
	public void mostrarEntidad(Entidad e) {
		
		laberinto.add(e.getRepresentacionGrafica().getDibujo());
		e.getRepresentacionGrafica().getDibujo().setVisible(true);

	}
	
	public void removerEntidad(Entidad e) {
		e.getRepresentacionGrafica().getDibujo().setVisible(false);
	}
	
	private class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if(mijuego.sigueEnJuego()) {
				 switch(e.getKeyCode()) {
				 
	             case KeyEvent.VK_LEFT: { mijuego.operar(Juego.moverIzquierda); break; }
	             case KeyEvent.VK_RIGHT: { mijuego.operar(Juego.moverDerecha); break; }
	             case KeyEvent.VK_UP: { mijuego.operar(Juego.moverArriba); break; }
	             case KeyEvent.VK_DOWN: { mijuego.operar(Juego.moverAbajo); break; }
	             
	         	}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}	
	
	
	
	public void cambioPuntaje() {
		text_puntaje.setText("Puntaje: "+ mijuego.getPuntaje());
		System.out.print("puntaje essss: " + mijuego.getPuntaje());
	}

	public void finDeJuego() {

	}
}