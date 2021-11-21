package grafica;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class VentanaInicio extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel inicioJuego;

	public VentanaInicio() {
		// Configuracion de la Ventana Inicio
		setTitle("The Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Images/generales/icono.png")));
		setSize(new Dimension(915, 640));
		setResizable(false);
		this.agregarBotones();
		this.agregarFondo();

	}

	public void agregarBotones() {
		// Boton Inicio
		JButton btnInicio = new JButton("");
		btnInicio.setVerticalAlignment(SwingConstants.BOTTOM);
		btnInicio.setBounds(320, 487, 272, 54);
		btnInicio.setBackground(new Color(220, 20, 60));

		String rutaBotonInicio = this.getClass().getResource("/Images/generales/boton_inicio.png").toString();
		ImageIcon fotoBotonInicio = null;
		try {
			fotoBotonInicio = new ImageIcon(new URL(rutaBotonInicio));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		btnInicio.setIcon(fotoBotonInicio);
		btnInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Gui ingresoNivel1= new Gui();
				VentanaDominio ingresoDominio = new VentanaDominio();
				ingresoDominio.setVisible(true);
				setVisible(false);
			}

		});
		getContentPane().setLayout(null);
		getContentPane().add(btnInicio);

		// Boton Instrucciones
		JButton btnInstrucciones = new JButton("");
		btnInstrucciones.setVerticalAlignment(SwingConstants.BOTTOM);
		btnInstrucciones.setBounds(320, 546, 272, 54);
		btnInstrucciones.setBackground(new Color(220, 20, 60));

		String rutaBotonInstruc = this.getClass().getResource("/Images/generales/boton_instrucciones.png").toString();
		ImageIcon fotoBotonInstruc = null;
		try {
			fotoBotonInstruc = new ImageIcon(new URL(rutaBotonInstruc));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		btnInstrucciones.setIcon(fotoBotonInstruc);
		btnInstrucciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		btnInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaInstrucciones ventaInt = new VentanaInstrucciones();
				ventaInt.setVisible(true);
			}

		});
		getContentPane().setLayout(null);
		getContentPane().add(btnInstrucciones);

	}

	public void agregarFondo() {
		// Imagen del fondo de la Ventana Inicio
		String rutaFotoJuego = this.getClass().getResource("/Images/generales/fondoinicio.png").toString();
		ImageIcon fotoJuego = null;
		try {
			fotoJuego = new ImageIcon(new URL(rutaFotoJuego));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaJuego = fotoJuego.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);

		// Label que contiene la imagen del fondo de la Ventana Inicio
		inicioJuego = new JLabel("");
		inicioJuego.setBounds(0, 0, 900, 600);
		getContentPane().add(inicioJuego);
		inicioJuego.setIcon(new ImageIcon(medidaJuego));
		getContentPane().add(inicioJuego, BorderLayout.CENTER);
	}
}