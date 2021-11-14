package entidades.nomovibles.items;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class Cuchillo extends ItemB {

	public Cuchillo(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho = 25;
		alto = 10;
		miRep = new RepresentacionGrafica(rutaImg);
	}

	public Cuchillo() {

	}

	public void accept(VisitorEntidad v) {

	}

}
