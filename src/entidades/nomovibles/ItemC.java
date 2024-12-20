package entidades.nomovibles;

import entidades.Entidad;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class ItemC extends Entidad {
	// JDC: Energizante, PC: PotionV , AU: huevo frito

	public ItemC(int val, Coordenada c, String rutaImg) {
		alive = true;
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
