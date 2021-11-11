package Entidad.Enemigo;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Boss extends Enemigo {

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

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	@Override
	public void accept(VisitorEntidad v) {
		v.visit(this);

	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub

	}
}
