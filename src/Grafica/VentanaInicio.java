package Grafica;

import java.awt.EventQueue;
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio ventana = new VentanaInicio();
					ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaInicio() {
		
		//Configuracion de la Ventana Inicio
		setTitle("PACMAN 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuiNivel1.class.getResource("/Images/icono.png")));
		setSize(new Dimension(900, 600));
		setResizable(false);
		
		//Imagen del fondo de la Ventana Inicio
		String rutaFotoJuego = this.getClass().getResource("/Images/juegoInicio.png").toString();
		ImageIcon fotoJuego = null;
		try {
			fotoJuego = new ImageIcon(new URL(rutaFotoJuego));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaJuego = fotoJuego.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		
		//Boton Nivel 1
		JButton btnNivel1 = new JButton("");
		btnNivel1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNivel1.setBounds(87, 394, 227, 77);
		btnNivel1.setBackground(Color.black);
		
		
		String rutaBotonNivel1 = this.getClass().getResource("/Images/boton_lvl1.png").toString();
		ImageIcon fotoBotonNivel1 = null;
		try {
			fotoBotonNivel1 = new ImageIcon(new URL(rutaBotonNivel1));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		btnNivel1.setIcon(fotoBotonNivel1); 
		btnNivel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		
		btnNivel1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
					GuiNivel1 ingresoNivel1= new GuiNivel1();
					ingresoNivel1.setVisible(true);
					setVisible(false); 
					}
					
				});
		getContentPane().setLayout(null);
		
		//Boton Nivel 2
		JButton btnNivel2 = new JButton("");
		btnNivel2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNivel2.setBounds(332, 394, 227, 77);
		btnNivel2.setBackground(Color.black);
		String rutaBotonNivel2 = this.getClass().getResource("/Images/boton_lvl2.png").toString();
		ImageIcon fotoBotonNivel2 = null;
		try {
			fotoBotonNivel2 = new ImageIcon(new URL(rutaBotonNivel2));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		getContentPane().setLayout(null);
		btnNivel2.setIcon(fotoBotonNivel2); 
		btnNivel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		
		btnNivel2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
					GuiNivel2 ingresoNivel2= new GuiNivel2();
					ingresoNivel2.setVisible(true);
					setVisible(false); 
					}
					
				});
		
		//Boton Nivel 3
		JButton btnNivel3 = new JButton("");
		btnNivel3.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNivel3.setBounds(575, 394, 227, 77);
		btnNivel3.setBackground(Color.black);
		
		String rutaBotonNivel3 = this.getClass().getResource("/Images/boton_lvl3.png").toString();
		ImageIcon fotoBotonNivel3 = null;
		try {
			fotoBotonNivel3 = new ImageIcon(new URL(rutaBotonNivel3));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		getContentPane().setLayout(null);
		
		btnNivel3.setIcon(fotoBotonNivel3); 
		btnNivel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		
		btnNivel3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
					GuiNivel3 ingresoNivel3= new GuiNivel3();
					ingresoNivel3.setVisible(true);
					setVisible(false); 
					}
					
				});
		getContentPane().add(btnNivel3);
		getContentPane().add(btnNivel2);
		getContentPane().add(btnNivel1);
				
		//Label que contiene la imagen del fondo de la Ventana Inicio
		inicioJuego = new JLabel("");
		inicioJuego.setBounds(0, 0, 894, 571);
		getContentPane().add(inicioJuego);
		inicioJuego.setIcon(new ImageIcon(medidaJuego));
		getContentPane().add(inicioJuego, BorderLayout.CENTER);
		
		
		
	}
}