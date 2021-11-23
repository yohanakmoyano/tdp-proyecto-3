package entidades.nomovibles.items;

import entidades.nomovibles.EntidadNoMovible;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class ItemB extends EntidadNoMovible {
	//JDC: Cuchillo , AU pistola , PC: PowerPellets
	
	
	public ItemB(int val, Coordenada c, String rutaImg) {
		alive = true;
		caminable = true;
		valor = val;
		posicion = c;
		ancho = 25;
		alto = 13;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}

	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

}
