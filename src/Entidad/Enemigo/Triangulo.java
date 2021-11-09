package Entidad.Enemigo;

import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Triangulo extends Enemigo{
public Triangulo(Coordenada c) {
		
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
	public void morir() {
		// TODO Auto-generated method stub
		
	}

}
