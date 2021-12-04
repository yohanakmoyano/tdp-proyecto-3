package entidades.nomovibles.items;

import entidades.nomovibles.EntidadNoMovible;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class ItemEfecto extends EntidadNoMovible{
	
	public ItemEfecto(int val, Coordenada c, String rutaImg) {
		alive = true;
		caminable = true;
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
