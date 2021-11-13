package grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entidades.Entidad;
import logica.Juego;


public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelprincipal;
	private JPanel laberinto;
	
	private Juego mijuego;
	private JLabel labelEntidad;
	private JLabel fondoNivel;

	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Images/icono.png")));
		setTitle("PACMAN 2.0");
		setSize(new Dimension(900, 600));
		setResizable(false);

		panelprincipal = new JPanel();
		panelprincipal.setBounds(0, 0, 900, 600);
		getContentPane().add(panelprincipal);
		panelprincipal.setVisible(true);
		panelprincipal.setLayout(null);
		
		laberinto = new JPanel();
		laberinto.setBounds(197, 0, 501, 553);
		panelprincipal.add(laberinto);
		laberinto.setLayout(new GridLayout(20, 20, 0, 0));
		laberinto.setVisible(true);
		laberinto.setLayout(null);
		laberinto.setBackground(Color.black);
		
		mijuego = new Juego(this);
		mijuego.iniciarJuego();

		
	}
	public void mostrarImagenFondo(String s) {
		ImageIcon fotoJuego = null;
		try {
			fotoJuego = new ImageIcon(new URL(s));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Image medidaJuego = fotoJuego.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		getContentPane().setLayout(null);
		fondoNivel = new JLabel();
		fondoNivel.setVerticalAlignment(SwingConstants.BOTTOM);
		fondoNivel.setBounds(0, 0, 890, 561);
		panelprincipal.add(fondoNivel);
		fondoNivel.setIcon(new ImageIcon(medidaJuego));;
	}
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

	}

	public void cambioPuntaje() {

	}

	public void finDeJuego() {

	}

}