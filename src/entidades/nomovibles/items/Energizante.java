package entidades.nomovibles.items;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class Energizante extends ItemC {

	public Energizante(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho = 15;
		alto = 30;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}
	
	public void accept(VisitorEntidad v) {
		v.visit(this);
	}
	
}
