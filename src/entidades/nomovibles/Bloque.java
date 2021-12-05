package entidades.nomovibles;

import entidades.Entidad;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class Bloque extends Entidad {

	public Bloque(Coordenada c, String rutaImg, int anc, int alt) {
		valor = 0;
		posicion = c;
		ancho = anc;
		alto = alt;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}

	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

}
