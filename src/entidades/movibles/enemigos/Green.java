package entidades.movibles.enemigos;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEnemigo;
import patrones.visitor_entidad.VisitorEntidad;

public class Green extends EnemigoD{
	public Green(Coordenada c, String rutaImg) {
		ultMovimiento = reposo;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		miVisitor = new VisitorEnemigo(this);
		posicion = c;
		ancho = 40;
		factorMovX = ancho/2;
		alto = 48;
		factorMovY = alto/2;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}

}
