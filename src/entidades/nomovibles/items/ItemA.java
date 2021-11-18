package entidades.nomovibles.items;

import entidades.nomovibles.Item;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public  class ItemA extends Item {
// JDC: Galleta , AU: por definir , PC: pacDoct
	public ItemA(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho = 13;
		alto = 10;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}
	
	public void accept(VisitorEntidad v) {
		v.visit(this);
	}
	
}
