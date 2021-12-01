package entidades.movibles.enemigos;

import entidades.movibles.EntidadMovible;
import logica.Coordenada;
import logica.Movimiento;
import logica.Salon;

public abstract class Enemigo extends EntidadMovible {
	protected int valor;
	protected Salon miSalon = Salon.getInstance();
	public static final int ejeX = 0;
	public static final int ejeY = 1;	
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getValor() {
		return valor;
	}
	
	public abstract void mover(Coordenada posDest, int eje, Movimiento mov);
	
	@Override
	public void moverArriba() {
		puedoMovermeDown = true;
		ultMovimiento = ultMovUp;
		actualizarMov = posicion.getY() - (factorMovY*velocidad);
		posicion.setY(actualizarMov);
		miRep.moverArriba(factorMovY);
	}

	@Override
	public void moverAbajo() {
		puedoMovermeUp = true;
		ultMovimiento = ultMovDown;
		actualizarMov = posicion.getY() + (factorMovY*velocidad);
		posicion.setY(actualizarMov);
		miRep.moverAbajo(factorMovY);
	}

	@Override
	public void moverIzquierda() {
		puedoMovermeDer = true;
		ultMovimiento = ultMovIzq;
		actualizarMov = posicion.getX() - (factorMovX*velocidad);
		posicion.setX(actualizarMov);
		miRep.moverIzquierda(factorMovX);
	}

	@Override
	public void moverDerecha() {
		puedoMovermeIzq = true;
		ultMovimiento = ultMovDer;
		actualizarMov = posicion.getX() + (factorMovX*velocidad);
		posicion.setX(actualizarMov);
		miRep.moverDerecha(factorMovX);
	}
	
}
