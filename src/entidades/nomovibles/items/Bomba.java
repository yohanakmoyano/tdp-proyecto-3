package entidades.nomovibles.items;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class Bomba extends ItemD {

	public Bomba(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho = 25;
		alto = 25;
		miRep = new RepresentacionGrafica(rutaImg);
	}

	public Bomba() {

	}

	public void accept(VisitorEntidad v) {

	}

}
