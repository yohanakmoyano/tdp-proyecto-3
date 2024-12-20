package grafica;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.Image;

public class FinDelJuego extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel inicioJuego;

	public FinDelJuego(Gui miGui, int opcion) {
		// Configuracion del panel fin de juego
		setBounds(0, 0, 900, 600);
		setLayout(null);
		String rutaFotoJuego = null;
		// Imagen del fondo de la ventana GameOver
		if (opcion == 1)
			rutaFotoJuego = this.getClass().getResource("/Images/generales/game_over.png").toString();
		// Imagen del fondo de la ventana Ganaste
		if (opcion == 2)
			rutaFotoJuego = this.getClass().getResource("/Images/generales/Ganaste.png").toString();

		ImageIcon fotoJuego = null;
		try {
			fotoJuego = new ImageIcon(new URL(rutaFotoJuego));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Image medidaJuego = fotoJuego.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);

		// Label que contiene la imagen del fondo de la ventana
		inicioJuego = new JLabel("");
		inicioJuego.setBounds(0, 0, 894, 571);
		inicioJuego.setIcon(new ImageIcon(medidaJuego));
		add(inicioJuego);

	}
}
