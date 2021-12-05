package entidades.nomovibles;

import entidades.Entidad;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class ItemA extends Entidad {
// JDC: Galleta , AU: hojitas , PC: pacDoct

	public ItemA(int val, Coordenada c, String rutaImg) {
		alive = true;
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
