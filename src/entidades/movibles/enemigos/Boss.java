package entidades.movibles.enemigos;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class Boss extends EnemigoA {

	public Boss(Coordenada c, String rutaImg) {
		posicion = c;
		ancho =40;
		alto =48;
		miRep = new RepresentacionGrafica(rutaImg);
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void moverArriba() {
		actualizarMov = posicion.getY() - (alto/2);
		posicion.setY(actualizarMov);
		
	}

	@Override
	protected void moverAbajo() {
		actualizarMov = posicion.getY() + (alto/2);
		posicion.setY(actualizarMov);
		
	}

	@Override
	protected void moverIzq() {
		actualizarMov = posicion.getX() - (ancho/2);
		posicion.setX(actualizarMov);
		
	}

	@Override
	protected void moverDer() {
		actualizarMov = posicion.getX() + (ancho/2);
		posicion.setX(actualizarMov);
		
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
