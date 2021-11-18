package entidades.nomovibles.items;

import entidades.nomovibles.Item;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public  class ItemE extends Item {
	//JDC: Dinero, AU: por definir , PC: Fruit
	public ItemE(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho = 30;
		alto = 20;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}

	public void accept(VisitorEntidad v) {
		v.visit(this);
	}


}
