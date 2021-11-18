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
import entidades.movibles.jugadores.Jugador_456;
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
	//private JLabel labelEntidad;
	private JLabel fondoNivel;
	private JTextField text_puntaje;
	private JTextField text_vidas;
	private Clip clip;
	private JLabel labelPotion;
	//private AudioPlayer ap;
	//private Thread audio;
	//private JToggleButton jToggleButtonAudio;
	protected static Gui myInstance;

	private Gui(Juego juego) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Images/generales/icono.png")));
		setTitle("PACMAN 2.0");
		setSize(new Dimension(900, 600));
		setResizable(false);
		this.setVisible(true);
		//initAudio();
		
		//Panel principal
		panelprincipal = new JPanel();
		panelprincipal.setBounds(0, 0, 900, 600);
		getContentPane().add(panelprincipal);
		panelprincipal.setVisible(true);
		panelprincipal.setLayout(null);
		
		JButton b_musica= new JButton("Musica ON");
		b_musica.setBounds(770, 510, 120, 20);
		panelprincipal.add(b_musica);
		b_musica.setFocusable(false);
		b_musica.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 10));

		JButton b_musicaOff= new JButton("Musica OFF");
		b_musicaOff.setBounds(770, 479, 120, 20);
		panelprincipal.add(b_musicaOff);
		b_musicaOff.setFocusable(false);
		b_musicaOff.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 10));

		requestFocusInWindow();

		
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
		mijuego = juego;
		
		//Oyentes de teclados
		KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		setFocusable(true);
		getContentPane().setLayout(null);
		
		/*
		jToggleButtonAudio = new JToggleButton();
		panelprincipal.add(jToggleButtonAudio);
		jToggleButtonAudio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/generales/game_over.png")));
		jToggleButtonAudio.setBounds(221, 77, 46, 39);
		jToggleButtonAudio.setOpaque(false);
		jToggleButtonAudio.setFocusable(false);
		jToggleButtonAudio.setSelected(true);
		
		jToggleButtonAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jToggleButtonAudioActionPerformed(evt);
			}
		});*/
		
		
		b_musica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				URL path=this.getClass().getResource("/audio/JDC.wav");
				try {
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
					clip = AudioSystem.getClip();

					clip.open(audioInput);
					clip.start();


				}catch(IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
					e1.printStackTrace();
				}

			}
		});
		
		
		b_musicaOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clip.stop();
			}
		});
		
		}
	//private void initAudio() {
		
//	}
	
	/*
	private void jToggleButtonAudioActionPerformed(ActionEvent evt) {
		System.out.println("entre aca");
		if(this.jToggleButtonAudio.isSelected()) {
			audioOff();
		} else {
			audioOn();
		}
	}
	
	private void audioOn() {
		jToggleButtonAudio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("/Images/generales/boton_musica.png")));
		ap = new AudioPlayer("\\\\Audio\\\\JDC.mp3");
		audio = new Thread(ap);
		audio.start();
	}

	private void audioOff() {
		jToggleButtonAudio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("/Images/generales/boton_musica.png")));
		ap = null;
		audio.stop();
		//audio.suspend();
		//audio.interrupt();
		audio = null;
	}
	*/

	
		public static Gui getGui(Juego juego) {
			if(myInstance == null)
				myInstance = new Gui(juego);
			return myInstance;
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
			fondoNivel.setIcon(new ImageIcon(medidaJuego));
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
	             case KeyEvent.VK_SPACE:{ mijuego.operar(Juego.ponerItem); break;}
	         	}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}	
	
	
	public void cambioPuntaje() {
		text_puntaje.setText("Puntaje: "+ mijuego.getPuntaje());
		//System.out.print("puntaje essss: " + mijuego.getPuntaje());
	}
	
	public void PasoDeNivel() {
		panelprincipal.removeAll();
  		ImageIcon img_Siguiente_nivel = new ImageIcon(getClass().getClassLoader().getResource("Images/generales/next_level.png"));
		JLabel lbl_Siguiente_nivel = new JLabel(img_Siguiente_nivel);	
		int ancho = img_Siguiente_nivel.getIconWidth();
		int largo = img_Siguiente_nivel.getIconHeight();
		lbl_Siguiente_nivel.setBounds(0, 0, ancho, largo);
		
		this.setSize(ancho, largo);
		panelprincipal.add(lbl_Siguiente_nivel);	
		panelprincipal.repaint();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void finDeJuego() {
		panelprincipal.removeAll();
  		ImageIcon img_gameOver = new ImageIcon(getClass().getClassLoader().getResource("Images/generales/game_over.png"));
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

	public void agregarItem() {
		ImageIcon img_potion = new ImageIcon(getClass().getClassLoader().getResource("Images/generales/bomba_nivel1.png"));
		labelPotion = new JLabel(img_potion);
		labelPotion.setBounds(725, 224, 25, 25);
		panelprincipal.add(labelPotion);
		panelprincipal.repaint();
	}
}