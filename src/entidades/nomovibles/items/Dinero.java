package entidades.nomovibles.items;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class Dinero extends ItemE {

	public Dinero(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho = 30;
		alto = 20;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}

	public Dinero() {

	}

	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

}
