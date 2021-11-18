package entidades.nomovibles.items;

import entidades.nomovibles.Item;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class ItemB extends Item {
	//JDC: Cuchillo , AU por definir , PC: PowerPellets
	public ItemB(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho = 25;
		alto = 7;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}

	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

}
