package Grafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GuiNivel1 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelNivel1; 
	private JLabel laberintoNivel1;
	private JLabel fondoNivel1;

	public GuiNivel1() {
		
		//Configuracion de la Ventana GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuiNivel1.class.getResource("/Images/icono.png")));
		setTitle("PACMAN 2.0");
		setSize(new Dimension(900, 600));
		setResizable(false);
		
		//Imagen del fondo de la Ventana Inicio
		String rutaFotoJuego = this.getClass().getResource("/Images/fondo_nivel1.png").toString();
	    ImageIcon fotoJuego = null;
		try {
			fotoJuego = new ImageIcon(new URL(rutaFotoJuego));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaJuego = fotoJuego.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		
		//Label del fondo 
		fondoNivel1=new JLabel();
		fondoNivel1.setBounds(211, 71, 559, 479);
		fondoNivel1.setIcon(new ImageIcon(medidaJuego));
		getContentPane().add(fondoNivel1);
		
		//panel del laberinto
		panelNivel1= new JPanel();
		panelNivel1.setBounds(0, 0, 900, 759);
		getContentPane().add(panelNivel1);
		panelNivel1.setVisible(true);
		
		//Imagen del fondo del laberinto
		String rutaLaberinto = this.getClass().getResource("/Images/laberinto_nivel1.png").toString();
	    ImageIcon fotoLaberinto = null;
		try {
			fotoLaberinto = new ImageIcon(new URL(rutaLaberinto));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaLaberinto = fotoLaberinto.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		
		//Label del laberinto
		laberintoNivel1=new JLabel();
		laberintoNivel1.setBounds(211, 71, 559, 479);
		laberintoNivel1.setIcon(new ImageIcon(medidaLaberinto));
		panelNivel1.add(laberintoNivel1);
		
		
		
	}
}
