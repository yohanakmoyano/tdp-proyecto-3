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
import java.awt.Panel;


public class GuiNivel1 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelNivel1; 
	private JLabel fondoNivel1;
	private JLabel galleta; 
	private JLabel dinero; 
	private JLabel bomba; 
	private JLabel cuchillo; 
	private JLabel energizante; 

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
		getContentPane().setLayout(null);
		
		//panel del laberinto
		panelNivel1= new JPanel();
		//panelNivel1.setBounds(0, 0, 890, 561);
		panelNivel1.setBounds(0, 0, 900, 600);
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

		Image medidaLaberinto = fotoLaberinto.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
		panelNivel1.setLayout(null);
		
		//Label Galleta
		galleta=new JLabel();
		galleta.setVerticalAlignment(SwingConstants.BOTTOM);
		galleta.setBounds(0, 0, 10, 10);
		panelNivel1.add(galleta);
		
		//Label del fondo 
		fondoNivel1=new JLabel();
		fondoNivel1.setVerticalAlignment(SwingConstants.BOTTOM);
		fondoNivel1.setBounds(0, 0, 890, 561);
		panelNivel1.add(fondoNivel1);
		fondoNivel1.setBackground(Color.BLUE);
		fondoNivel1.setIcon(new ImageIcon(medidaJuego));
		fondoNivel1.setBackground(Color.BLUE);
		
		Panel panel = new Panel();
		panel.setBounds(197, 0, 501, 561);
		panelNivel1.add(panel);
		panel.setLayout(null);
		
		JLabel laberintoNivel1 = new JLabel();
		laberintoNivel1.setBounds(0, 0, 600, 640);
		laberintoNivel1.setIcon(new ImageIcon(medidaLaberinto));
		panel.add(laberintoNivel1);
		//fondoNivel1.setIcon(new ImageIcon(medidaJuego));
		
	}
}
