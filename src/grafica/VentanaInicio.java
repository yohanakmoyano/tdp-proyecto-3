package grafica;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Images/icono.png")));
		setSize(new Dimension(915, 640));
		setResizable(false);
		
		//Imagen del fondo de la Ventana Inicio
		String rutaFotoJuego = this.getClass().getResource("/Images/dominio_niveles.png").toString();
		ImageIcon fotoJuego = null;
		try {
			fotoJuego = new ImageIcon(new URL(rutaFotoJuego));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaJuego = fotoJuego.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		
		//Boton Inicio
		JButton btnInicio = new JButton("");
		btnInicio.setVerticalAlignment(SwingConstants.BOTTOM);
		btnInicio.setBounds(75, 522, 222, 78);
		btnInicio.setBackground(Color.black);
		
		
		String rutaBotonInicio = this.getClass().getResource("/Images/boton_iniciar.png").toString();
		ImageIcon fotoBotonInicio = null;
		try {
			fotoBotonInicio = new ImageIcon(new URL(rutaBotonInicio));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		btnInicio.setIcon(fotoBotonInicio); 
		btnInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		
		btnInicio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
					Gui ingresoNivel1= new Gui();
					ingresoNivel1.setVisible(true);
					setVisible(false); 
					}
					
				});
		getContentPane().setLayout(null);
		getContentPane().add(btnInicio);
				
		//Label que contiene la imagen del fondo de la Ventana Inicio
		inicioJuego = new JLabel("");
		inicioJuego.setBounds(0, 0, 900, 600);
		getContentPane().add(inicioJuego);
		inicioJuego.setIcon(new ImageIcon(medidaJuego));
		getContentPane().add(inicioJuego, BorderLayout.CENTER);
		
		
		
	}
}