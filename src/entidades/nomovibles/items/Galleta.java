package entidades.nomovibles.items;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class Galleta extends ItemA {

	public Galleta(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho = 13;
		alto =10;
		miRep = new RepresentacionGrafica(rutaImg);
	}

	public Galleta() {

	}

	public void accept(VisitorEntidad v) {

	}
	
}
