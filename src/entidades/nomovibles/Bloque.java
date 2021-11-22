package entidades.nomovibles;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;
import patrones.visitor_entidad.VisitorNoMovibles;

public class Bloque extends EntidadNoMovible {
	public Bloque(Coordenada c, String rutaImg, int anc, int alt) {
		caminable = false;
		valor = 0;
		miVisitor = new VisitorNoMovibles(this);
		posicion = c;
		ancho = anc;//10;
		alto = alt;//60;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}

	@Override
	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

}
