package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import logica.Juego;

@SuppressWarnings("serial")
public class VentanaDominio extends JFrame {
	private JLabel inicioJuego;

	public VentanaDominio() {
		// Configuracion de la Ventana Inicio
		setTitle("THE GAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Images/generales/icono.png")));
		setSize(new Dimension(915, 640));
		setResizable(false);
		this.agregarBotones();
		this.agregarFondo();
	}

	public void agregarBotones() {
		// Boton Juego del Calamar
		JButton btnInicio_JDC = new JButton("");
		btnInicio_JDC.setBounds(93, 522, 190, 50);
		btnInicio_JDC.setBackground(new Color(220, 20, 60));

		String rutaBotonJDC = this.getClass().getResource("/Images/generales/boton_1.png").toString();
		ImageIcon fotoBotonJDC = null;
		try {
			fotoBotonJDC = new ImageIcon(new URL(rutaBotonJDC));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		btnInicio_JDC.setIcon(fotoBotonJDC);
		btnInicio_JDC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		btnInicio_JDC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego juego = new Juego(1);
				juego.setDominio(1);
				juego.iniciarJuego();
				setVisible(false);
			}

		});
		getContentPane().setLayout(null);
		getContentPane().add(btnInicio_JDC);

		// Boton Among Us
		JButton btnInicio_AU = new JButton("");
		btnInicio_AU.setBounds(357, 522, 190, 50);
		btnInicio_AU.setBackground(new Color(220, 20, 60));

		String rutaBotonAU = this.getClass().getResource("/Images/generales/boton_2.png").toString();
		ImageIcon fotoBotonAU = null;
		try {
			fotoBotonAU = new ImageIcon(new URL(rutaBotonAU));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		btnInicio_AU.setIcon(fotoBotonAU);
		btnInicio_AU.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		btnInicio_AU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego juego = new Juego(1);
				juego.setDominio(2);
				juego.iniciarJuego();
				setVisible(false);
			}

		});
		getContentPane().setLayout(null);
		getContentPane().add(btnInicio_AU);

		// Boton Among Pacman
		JButton btnInicio_PM = new JButton("");
		btnInicio_PM.setForeground(Color.WHITE);
		btnInicio_PM.setBounds(628, 522, 190, 50);
		btnInicio_PM.setBackground(new Color(220, 20, 60));

		String rutaBotonPM = this.getClass().getResource("/Images/generales/boton_3.png").toString();
		ImageIcon fotoBotonPM = null;
		try {
			fotoBotonPM = new ImageIcon(new URL(rutaBotonPM));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		btnInicio_PM.setIcon(fotoBotonPM);
		btnInicio_PM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		btnInicio_PM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego juego = new Juego(1);
				juego.setDominio(3);
				juego.iniciarJuego();
				setVisible(false);
			}

		});
		getContentPane().setLayout(null);
		getContentPane().add(btnInicio_PM);

	}

	public void agregarFondo() {
		// Imagen del fondo de la Ventana Inicio
		String rutaFotoJuego = this.getClass().getResource("/Images/generales/dominios.png").toString();
		ImageIcon fotoJuego = null;
		try {
			fotoJuego = new ImageIcon(new URL(rutaFotoJuego));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Image medidaJuego = fotoJuego.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		// Label que contiene la imagen del fondo de la Ventana dominio
		inicioJuego = new JLabel("");
		inicioJuego.setBounds(0, 0, 900, 600);
		getContentPane().add(inicioJuego);
		inicioJuego.setIcon(new ImageIcon(medidaJuego));
		getContentPane().add(inicioJuego, BorderLayout.CENTER);

	}

}