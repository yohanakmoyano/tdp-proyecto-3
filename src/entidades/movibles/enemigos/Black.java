package entidades.movibles.enemigos;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEnemigo;


public class Black extends EnemigoA {

	public Black(Coordenada c, String rutaImg) {
		ultMovimiento = reposo;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		miVisitor = new VisitorEnemigo(this);
		posicion = c;
		ancho = 20;
		factorMovX = ancho/2;
		alto = 20;
		factorMovY = alto/2;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}

}
