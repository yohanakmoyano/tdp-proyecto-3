package Entidad.Item;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Cuchillo extends ItemB {

	public Cuchillo(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho = 40;
		alto = 58;
		// String
		// rutaCuchillo=this.getClass().getResource("/Images/cuchillo_nivel1.png").toString();
		miRep = new RepresentacionGrafica(rutaImg);
	}

	public Cuchillo() {

	}

	public void accept(VisitorEntidad v) {

	}
	
	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}
