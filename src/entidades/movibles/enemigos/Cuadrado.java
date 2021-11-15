package entidades.movibles.enemigos;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class Cuadrado extends EnemigoB {
	public Cuadrado(Coordenada c, String rutaImg) {
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
	public void morir() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean perderVida() {
		// TODO Auto-generated method stub
		return false;
	}
}
