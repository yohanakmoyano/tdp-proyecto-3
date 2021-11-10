package Entidad.Item;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Galleta extends ItemA {

	public Galleta(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho = 22;
		alto = 23;
		// String
		// rutaGalleta=this.getClass().getResource("/Images/galleta_nivel1.png").toString();
		miRep = new RepresentacionGrafica(rutaImg);
	}

	public Galleta() {

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
