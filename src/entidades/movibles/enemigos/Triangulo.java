package entidades.movibles.enemigos;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEnemigo;
import patrones.visitor_entidad.VisitorEntidad;

public class Triangulo extends EnemigoC {
	public Triangulo(Coordenada c, String rutaImg) {
		miVisitor = new VisitorEnemigo(this);
		posicion = c;
		ancho = 40;
		alto = 48;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}

	@Override
	public void moverArriba() {
		actualizarMov = posicion.getY() - (alto/2);
		posicion.setY(actualizarMov);
		miRep.moverArriba();
	}

	@Override
	public void moverAbajo() {
		actualizarMov = posicion.getY() + (alto/2);
		posicion.setY(actualizarMov);
		miRep.moverAbajo();
	}

	@Override
	public void moverIzquierda() {
		actualizarMov = posicion.getX() - (ancho/2);
		posicion.setX(actualizarMov);
		miRep.moverIzquierda();
	}

	@Override
	public void moverDerecha() {
		actualizarMov = posicion.getX() + (ancho/2);
		posicion.setX(actualizarMov);
		miRep.moverDerecha();
	}
	
	@Override
	public void accept(VisitorEntidad v) {
		v.visit(this);

	}

	@Override
	public boolean perderVida() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub

	}

}
