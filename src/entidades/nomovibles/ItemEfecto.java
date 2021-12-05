package entidades.nomovibles;

import entidades.Entidad;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class ItemEfecto extends Entidad {

	public ItemEfecto(int val, Coordenada c, String rutaImg) {
		alive = true;
		valor = val;
		posicion = c;
		alto = 70;
		ancho = 70;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}

	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

}
