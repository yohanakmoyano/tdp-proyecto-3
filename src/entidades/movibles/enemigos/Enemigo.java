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
	
	/**
	 * Precondicion: Debe ser posible mover de x1 a newPosDer o en su defecto de x1 a newPosIzq. 
	 * Esto es, no existen obstáculos, presentan un camino limpio.
	 * @param x1 coordenada X origen.
	 * @param x2 coordenada X destino.
	 */
	protected void moverEnX(int x1, int x2, int newPosDer, int newPosIzq, Movimiento mov) {
		if(x1 != x2) {
			if((x1 - x2) < 0) {//MoverDerecha
				while(posicion.getX() <= newPosDer) {
					mov.moverEnemigoDer(this);
				}
			} else { //MoverIzquierda
				while(posicion.getX() >= newPosIzq) {
					mov.moverEnemigoIzq(this);
				}
			}
		}
	}
	
	/**
	 * Precondicion: Debe ser posible mover de y1 a newPosUp o en su defecto de y1 a newPosDown. 
	 * Esto es, no existen obstáculos, presentan un camino limpio.
	 * @param y1 coordenada Y origen.
	 * @param y2 coordenada Y destino.
	 */
	protected void moverEnY(int y1, int y2, int newPosUp, int newPosDown, Movimiento mov) {
		if(y1 != y2) {
			if((y1 - y2) > 0) {//MoverUp
				while(posicion.getY() >= newPosUp) {
					mov.moverEnemigoUp(this);
				}
			} else {//MoverDown
				while(posicion.getY() <= newPosDown) {
					mov.moverEnemigoDown(this);
				}
			}
		}
	}
	
	
	@Override
	public void moverArriba() {
		puedoMovermeDown = true;
		ultMovimiento = ultMovUp;
		actualizarMov = posicion.getY() - (factorMovY);
		posicion.setY(actualizarMov);
		miRep.moverArriba(factorMovY);
	}

	@Override
	public void moverAbajo() {
		puedoMovermeUp = true;
		ultMovimiento = ultMovDown;
		actualizarMov = posicion.getY() + (factorMovY);
		posicion.setY(actualizarMov);
		miRep.moverAbajo(factorMovY);
	}

	@Override
	public void moverIzquierda() {
		puedoMovermeDer = true;
		ultMovimiento = ultMovIzq;
		actualizarMov = posicion.getX() - (factorMovX);
		posicion.setX(actualizarMov);
		miRep.moverIzquierda(factorMovX);
	}

	@Override
	public void moverDerecha() {
		puedoMovermeIzq = true;
		ultMovimiento = ultMovDer;
		actualizarMov = posicion.getX() + (factorMovX);
		posicion.setX(actualizarMov);
		miRep.moverDerecha(factorMovX);
	}
	
}
