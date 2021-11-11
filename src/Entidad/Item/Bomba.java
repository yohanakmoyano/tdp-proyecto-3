package Entidad.Item;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Bomba extends ItemD {

	public Bomba(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho = 16;//40;
		alto = 10;//58;
		// String rutaBomba =
		// this.getClass().getResource("/Images/bomba_nivel1.png").toString();
		miRep = new RepresentacionGrafica(rutaImg);
	}

	public Bomba() {

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
