package entidades.nomovibles.items;

import entidades.nomovibles.Item;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public  class ItemC extends Item {
	// JDC: Energizante, PC: PotionV , AU: por definir
	public ItemC(int val, Coordenada c, String rutaImg) {
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
