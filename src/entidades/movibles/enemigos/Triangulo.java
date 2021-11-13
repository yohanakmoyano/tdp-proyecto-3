package entidades.movibles.enemigos;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class Triangulo extends EnemigoC {
	public Triangulo(Coordenada c, String rutaImg) {
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
		// TODO Auto-generated method stub

	}

	@Override
	protected void moverAbajo() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void moverIzq() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void moverDer() {
		// TODO Auto-generated method stub

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
