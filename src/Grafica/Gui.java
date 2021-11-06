package Grafica;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import Entidad.Item.Bomba;
import Entidad.Item.Cuchillo;
import Entidad.Item.Dinero;
import Entidad.Item.Energizante;
import Entidad.Item.Galleta;
import Entidad.Jugador.Jugador_456;
import Logica.Coordenada;
import Logica.Juego;


import java.awt.Panel;


public class Gui extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelNivel1; 
	private JLabel fondoNivel1;
	private JLabel label_galleta; 
	private JLabel label_dinero; 
	private JLabel label_bomba; 
	private JLabel label_cuchillo; 
	private JLabel label_energizante; 
	private JLabel label_jugador; 
	private Juego mijuego;

	public Gui() {
		//Inicia Juego
		mijuego = new Juego();
		mijuego.iniciarJuego();
		
		//Configuracion de la Ventana GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Images/icono.png")));
		setTitle("PACMAN 2.0");
		setSize(new Dimension(900, 600));
		setResizable(false);
		
		//Imagen del fondo de la Ventana Inicio
		
		String rutaFotoJuego =null;
		if (mijuego.getNivel()==1)
				rutaFotoJuego=this.getClass().getResource("/Images/fondo_nivel1.png").toString();
		
		if (mijuego.getNivel()==2) {
			rutaFotoJuego = this.getClass().getResource("/Images/fondo_nivel2.png").toString();
		}
		if (mijuego.getNivel()==3) {
			 rutaFotoJuego = this.getClass().getResource("/Images/fondo_nivel3.png").toString();
		}
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
		
		Panel panel = new Panel();
		panel.setBounds(197, 0, 501, 553);
		panelNivel1.add(panel);
		panel.setLayout(null);
		
		//Label Cuchillo
		label_cuchillo=new JLabel();
		label_cuchillo.setBounds(83, 97, 40, 58);
		
		Coordenada coordenadaCuchillo=new Coordenada(85,90); 
	    Cuchillo cuchillo=new Cuchillo(1,coordenadaCuchillo);
		
		String rutaCuchillo = cuchillo.getRepresentacionGrafica().getRuta();
	    ImageIcon fotoCuchillo = null;
		try {
			fotoCuchillo = new ImageIcon(new URL(rutaCuchillo));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaCuchillo = fotoCuchillo.getImage().getScaledInstance(40, 9, Image.SCALE_DEFAULT);
		panelNivel1.setLayout(null);
		
		label_cuchillo.setIcon(new ImageIcon(medidaCuchillo)); 
		panel.add(label_cuchillo);
		
		//Label Bomba
		label_bomba=new JLabel();
		label_bomba.setBounds(112, 379, 40, 58);
		
		Coordenada coordenadaBomba=new Coordenada(85,90); 
	    Bomba bomba=new Bomba(1,coordenadaBomba);
		
		String rutaBomba = bomba.getRepresentacionGrafica().getRuta();
	    ImageIcon fotoBomba = null;
		try {
			fotoBomba = new ImageIcon(new URL(rutaBomba));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaBomba = fotoBomba.getImage().getScaledInstance(30, 31, Image.SCALE_DEFAULT);
		panelNivel1.setLayout(null);
		
		label_bomba.setIcon(new ImageIcon(medidaBomba)); 		
		panel.add(label_bomba);
		
		//Label Jugador
		label_jugador=new JLabel();
		label_jugador.setBounds(235, 441, 40, 58);
		
		Coordenada coordenadaJugador=new Coordenada(85,90); 
	    Jugador_456 jugador=new Jugador_456(coordenadaJugador, 100, 3); //agregar valores reales de velocidad y vidas
		
		String rutaJugador = jugador.getRepresentacionGrafica().getRuta();
	    ImageIcon fotoJugador = null;
		try {
			fotoJugador = new ImageIcon(new URL(rutaJugador));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaJugador = fotoJugador.getImage().getScaledInstance(30, 41, Image.SCALE_DEFAULT);
		panelNivel1.setLayout(null);
		
		label_jugador.setIcon(new ImageIcon(medidaJugador)); 
		panel.add(label_jugador);
		
		//Label Energizante
		label_energizante=new JLabel();
		label_energizante.setBounds(451, 137, 40, 58);
		
		Coordenada coordenadaEnergizante=new Coordenada(85,90); 
	    Energizante energizante=new Energizante(1,coordenadaEnergizante);
		
		String rutaEnergizante = energizante.getRepresentacionGrafica().getRuta();
	    ImageIcon fotoEnergizante = null;
		try {
			fotoEnergizante = new ImageIcon(new URL(rutaEnergizante));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaEnergizante = fotoEnergizante.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		panelNivel1.setLayout(null);
		
		label_energizante.setIcon(new ImageIcon(medidaEnergizante)); 
		panel.add(label_energizante);
		
	    //label galleta
		
		label_galleta=new JLabel();
		label_galleta.setVerticalAlignment(SwingConstants.BOTTOM);
		label_galleta.setBounds(163, 277, 22, 23);
		
	    Coordenada coordenadaGalleta=new Coordenada(65,65); 
	    Galleta galleta=new Galleta(1,coordenadaGalleta);
		
		String rutaGalleta = galleta.getRepresentacionGrafica().getRuta();
	    ImageIcon fotoGalleta = null;
		try {
			fotoGalleta = new ImageIcon(new URL(rutaGalleta));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaGalleta = fotoGalleta.getImage().getScaledInstance(15, 16, Image.SCALE_DEFAULT);
		panelNivel1.setLayout(null);
		
		label_galleta.setIcon(new ImageIcon(medidaGalleta)); 
		panel.add(label_galleta);
		
		//Label Dinero
		label_dinero=new JLabel();
		//label_cuchillo.setVerticalAlignment(SwingConstants.BOTTOM);
		label_dinero.setBounds(235, 345, 46, 23);
		
		Coordenada coordenadaDinero=new Coordenada(41,90); 
	    Dinero dinero=new Dinero(1,coordenadaDinero);
		
		String rutaDinero = dinero.getRepresentacionGrafica().getRuta();
	    ImageIcon fotoDinero = null;
		try {
			fotoDinero = new ImageIcon(new URL(rutaDinero));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaDinero = fotoDinero.getImage().getScaledInstance(30, 15, Image.SCALE_DEFAULT);
		panelNivel1.setLayout(null);
		
		label_dinero.setIcon(new ImageIcon(medidaDinero)); 
		panel.add(label_dinero); 
		
		
		//Imagen del fondo del laberinto
		String rutaLaberinto = this.getClass().getResource("/Images/laberinto_nivel1.png").toString();
	    ImageIcon fotoLaberinto = null;
		try {
			fotoLaberinto = new ImageIcon(new URL(rutaLaberinto));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaLaberinto = fotoLaberinto.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
		panelNivel1.setLayout(null);
		
		JLabel laberintoNivel1 = new JLabel();
		laberintoNivel1.setBounds(0, 0, 491, 640);
		laberintoNivel1.setIcon(new ImageIcon(medidaLaberinto));
		panel.add(laberintoNivel1);
		
		
		//Label del fondo 
		fondoNivel1=new JLabel();
		fondoNivel1.setVerticalAlignment(SwingConstants.BOTTOM);
		fondoNivel1.setBounds(0, 0, 890, 561);
		panelNivel1.add(fondoNivel1);
		fondoNivel1.setBackground(Color.BLUE);
		fondoNivel1.setIcon(new ImageIcon(medidaJuego));
		fondoNivel1.setBackground(Color.BLUE);
		
		
	}
	public void cambioPuntaje()  {
	
	}
    public void finDeJuego(){
	
	
	}
}
