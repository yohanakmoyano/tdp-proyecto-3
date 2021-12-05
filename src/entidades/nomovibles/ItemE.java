package entidades.nomovibles;

import entidades.Entidad;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class ItemE extends Entidad {
	// JDC: Dinero, AU: sombrero , PC: Fruit

	public ItemE(int val, Coordenada c, String rutaImg) {
		alive = true;
		caminable = true;
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
