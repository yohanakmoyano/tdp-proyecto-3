package grafica;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SwingConstants;

import entidades.Entidad;

import logica.Juego;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelprincipal;
	private JPanel laberinto;
	private Juego mijuego;
	// private JLabel labelEntidad;
	private JLabel fondoNivel;
	private JTextField text_puntaje;
	private JTextField text_vidas;
	private Clip clip;
	private JLabel labelPotion;
	private JLabel lbl_Siguiente_nivel;
	protected static Gui myInstance;

	private Gui(Juego juego) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Images/generales/icono.png")));
		setTitle("PACMAN 2.0");
		setSize(new Dimension(900, 600));
		setResizable(false);
		this.setVisible(true);
		
		// Panel principal
		panelprincipal = new JPanel();
		panelprincipal.setBounds(0, 0, 900, 600);
		getContentPane().add(panelprincipal);
		panelprincipal.setVisible(true);
		panelprincipal.setLayout(null);
		this.agregarBotonesMusica();
		
		// Panel laberinto
		laberinto = new JPanel();
		laberinto.setBounds(197, 0, 500, 552);
		panelprincipal.add(laberinto);
		laberinto.setLayout(new GridLayout(20, 20, 0, 0));
		laberinto.setVisible(true);
		laberinto.setLayout(null);
		laberinto.setBackground(Color.black);

		// Inicia miJuego
		mijuego = juego;
		
		// Text Puntaje
		text_puntaje = new JTextField();
		text_puntaje.setForeground(Color.WHITE);
		text_puntaje.setBackground(Color.DARK_GRAY);
		text_puntaje.setText("0");
		text_puntaje.setEditable(false);
		text_puntaje.setFont(new Font("Consolas", Font.BOLD, 22));
		text_puntaje.setBounds(725, 56, 137, 27);
		panelprincipal.add(text_puntaje);
		text_puntaje.setColumns(10);
		
		// Text Vidas
		text_vidas = new JTextField();
		text_vidas.setForeground(Color.WHITE);
		text_vidas.setBackground(Color.DARK_GRAY);
		text_vidas.setEditable(false);
		text_vidas.setColumns(10);
		text_vidas.setFont(new Font("Consolas", Font.BOLD, 22));
		text_vidas.setBounds(725, 140, 137, 27);
		panelprincipal.add(text_vidas);
		
		// Oyentes de teclados
		KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		setFocusable(true);
		getContentPane().setLayout(null);

	}

	
	//pasarle por parametro la musica correspondiente
	public void agregarBotonesMusica() {
		
		String rutaBotonSonidoOn = this.getClass().getResource("/Images/generales/sonidoOff.png").toString();
		ImageIcon fotoBotonSonidoOn = null;
		try {
			fotoBotonSonidoOn = new ImageIcon(new URL(rutaBotonSonidoOn));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		String rutaBotonSonidoOff = this.getClass().getResource("/Images/generales/sonidoOn.png").toString();
		ImageIcon fotoBotonSonidoOff = null;
		try {
			fotoBotonSonidoOff = new ImageIcon(new URL(rutaBotonSonidoOff));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		JButton boton_musicOff = new JButton();
		boton_musicOff.setBackground(Color.WHITE);
		boton_musicOff.setBounds(23, 11, 35, 35);
		boton_musicOff.setFocusable(false);
		boton_musicOff.setFont(new Font("Consolas", Font.BOLD, 12));
		boton_musicOff.setVisible(false);
		Image medidaSonidoOff = fotoBotonSonidoOff.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT);
		
		JButton boton_music = new JButton();
		boton_music.setBackground(Color.WHITE);
		boton_music.setBounds(23, 11, 35, 35);
		boton_music.setFocusable(false);
		boton_music.setFont(new Font("Consolas", Font.BOLD, 12));
		Image medidaSonidoOn = fotoBotonSonidoOn.getImage().getScaledInstance(35,35, Image.SCALE_DEFAULT);
		boton_music.setIcon(new ImageIcon(medidaSonidoOn));
		boton_music.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		
		boton_musicOff.setIcon(new ImageIcon(medidaSonidoOff));
		boton_music.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				URL path = mijuego.getMusica();//this.getClass().getResource("/audio/JDC.wav");
				try {
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
					clip = AudioSystem.getClip();

					clip.open(audioInput);
					clip.start();
					boton_musicOff.setVisible(true);
					boton_music.setVisible(false);

				} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
					e1.printStackTrace();
				}

			}
		});
		
		boton_musicOff.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		panelprincipal.add(boton_musicOff);
		panelprincipal.add(boton_music);
				boton_musicOff.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						clip.stop();
						boton_music.setVisible(true);
						boton_musicOff.setVisible(false);
					}
				});

		requestFocusInWindow();

	}

	public static Gui getGui(Juego juego) {
		if (myInstance == null)
			myInstance = new Gui(juego);
		return myInstance;
	}

	public void actualizarPuntaje(int puntaje) {
		text_puntaje.setText(" " + puntaje);
	}

	public void actualizarVidas(int v) {
		text_vidas.setText(" " + v);
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
		fondoNivel.setIcon(new ImageIcon(medidaJuego));
	}

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
			if (mijuego.sigueEnJuego()) {
				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT: {
					mijuego.operar(Juego.moverIzquierda);
					break;
				}
				case KeyEvent.VK_RIGHT: {
					mijuego.operar(Juego.moverDerecha);
					break;
				}
				case KeyEvent.VK_UP: {
					mijuego.operar(Juego.moverArriba);
					break;
				}
				case KeyEvent.VK_DOWN: {
					mijuego.operar(Juego.moverAbajo);
					break;
				}
				case KeyEvent.VK_SPACE: {
					mijuego.operar(Juego.ponerItem);
					break;
				}
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}

	public void PasoDeNivel() {
		//panelprincipal.removeAll();
		ImageIcon img_Siguiente_nivel = new ImageIcon(
				getClass().getClassLoader().getResource("Images/generales/next_level.png"));
		lbl_Siguiente_nivel = new JLabel(img_Siguiente_nivel);
		int ancho = img_Siguiente_nivel.getIconWidth();
		int largo = img_Siguiente_nivel.getIconHeight();
		
		lbl_Siguiente_nivel.setBounds(0, 0, ancho, largo);
		panelprincipal.add(lbl_Siguiente_nivel);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//lbl_Siguiente_nivel.setVisible(false);
		// Cerramos el juego
		//System.exit(0);
		//panelprincipal.removeAll();
	   //laberinto.removeAll();
	   // this.setVisible(false);
		//mijuego=new Juego(mijuego.getNivel());
	//	mijuego.setNivel(mijuego.getNivel());
		//mijuego.iniciarJuego();
		
		
	}

	public void finDeJuego() {
		panelprincipal.removeAll();
		ImageIcon img_gameOver = new ImageIcon(
				getClass().getClassLoader().getResource("Images/generales/game_over.png"));
		JLabel lbl_gameOver = new JLabel(img_gameOver);
		int ancho = img_gameOver.getIconWidth();
		int largo = img_gameOver.getIconHeight();
		lbl_gameOver.setBounds(0, 0, ancho, largo);

		this.setSize(ancho, largo);
		panelprincipal.add(lbl_gameOver);
		panelprincipal.repaint();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Cerramos el juego
		System.exit(0);
	}
	// Comentado temporalmente
	/*
	 * public void mostrarEntidad(Entidad e) { ImageIcon imagen = null; String
	 * rutaEntidad = e.getRepresentacionGrafica().getRuta(); int ancho =
	 * e.getAncho(); int alto = e.getAlto(); labelEntidad = new JLabel();
	 * labelEntidad.setBounds(e.getPosicion().getX(), e.getPosicion().getY(), ancho,
	 * alto); try { imagen = new ImageIcon(new URL(rutaEntidad)); } catch
	 * (MalformedURLException e1) { e1.printStackTrace(); } Image medidaEntidad =
	 * imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
	 * labelEntidad.setIcon(new ImageIcon(medidaEntidad));
	 * laberinto.add(labelEntidad); labelEntidad.setVisible(true);
	 * 
	 * }
	 */

	
	 public void agregarItem() { 
		 ImageIcon img_potion = new ImageIcon(getClass().getClassLoader().getResource("Images/generales/bomba_nivel1.png"));
		 labelPotion = new JLabel(img_potion);
		 labelPotion.setBounds(725, 224, 25, 25); 
		 panelprincipal.add(labelPotion);
		 panelprincipal.repaint();
	 }
	 
}