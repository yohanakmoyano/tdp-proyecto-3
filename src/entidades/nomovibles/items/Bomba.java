package entidades.nomovibles.items;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

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

}
