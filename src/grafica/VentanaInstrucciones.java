package grafica;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VentanaInstrucciones extends JFrame {
	private static final long serialVersionUID = 1L;
	//private JButton btnvolverInicio; 
	private JLabel inicioJuego;
	
	
	public VentanaInstrucciones() {
		
		//Configuracion de la Ventana Instrucciones
		setTitle("The Game");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Images/generales/icono.png")));
		setSize(new Dimension(915, 640));
		setResizable(false);
		
		//Imagen del fondo de la Ventana Instrucciones
		String rutaFotoJuego = this.getClass().getResource("/Images/generales/Instrucciones.png").toString();
		ImageIcon fotoJuego = null;
		try {
			fotoJuego = new ImageIcon(new URL(rutaFotoJuego));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaJuego = fotoJuego.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		getContentPane().setLayout(null);
		
		/*
		//Boton volverInicio
		btnvolverInicio = new JButton("");
		btnvolverInicio.setVerticalAlignment(SwingConstants.BOTTOM);
		btnvolverInicio.setBounds(377, 471, 141, 46);
		btnvolverInicio.setBackground(Color.black);
		
		String rutaBotonVolverInicio = this.getClass().getResource("/images/volver_atras.png").toString();
		ImageIcon fotoBotonVolverInicio = null;
		try {
			fotoBotonVolverInicio = new ImageIcon(new URL(rutaBotonVolverInicio));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		getContentPane().setLayout(null);
		
		btnvolverInicio.setIcon(fotoBotonVolverInicio); 
		btnvolverInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		btnvolverInicio.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				VentanaInicio inicio=new VentanaInicio(); 
				inicio.setVisible(true); 
				setVisible(false); 
			}
					
		});
		
		getContentPane().add(btnvolverInicio);
		*/
		
		//Label que contiene la imagen del fondo de la Ventana Instrucciones
		inicioJuego = new JLabel("");
		inicioJuego.setBounds(0, 0, 900, 600);
		getContentPane().add(inicioJuego);
		inicioJuego.setIcon(new ImageIcon(medidaJuego));
		getContentPane().add(inicioJuego, BorderLayout.CENTER);
		
		
		

	}
}