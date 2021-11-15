package entidades.movibles;

import entidades.Entidad;
import logica.Coordenada;

public abstract class EntidadMovible extends Entidad {
	protected int velocidad;
	protected int vidas;
	protected int actualizarMov;
	protected boolean puedoMovermeIzq;
	protected boolean puedoMovermeDer;
	protected boolean puedoMovermeUp;
	protected boolean puedoMovermeDown;
	
	protected int ultMovimiento;
	public static final int reposo = 0;
	public static final int ultMovIzq = 1;
	public static final int ultMovDer = 2;
	public static final int ultMovUp = 3;
	public static final int ultMovDown = 4;
	
	protected int factorMovX;
	protected int factorMovY;

	public int getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(int vel) {
		System.out.println("Modifico velocidad: old: "+velocidad+" new: "+vel);
		velocidad = vel;
	}
	
	public void resetearMovimientos() {
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
	}
	
	public int getUltMovimiento() {
		return ultMovimiento;
	}
	
	public boolean puedoMovermeIzq() {
		return puedoMovermeIzq;
	}
	
	public void setPuedoMovermeIzq(boolean mov) {
		puedoMovermeIzq = mov;
	}

	public boolean puedoMovermeDer() {
		return puedoMovermeDer;
	}
	
	public void setPuedoMovermeDer(boolean mov) {
		puedoMovermeDer = mov;
	}

	public boolean puedoMovermeUp() {
		return puedoMovermeUp;
	}
	
	public void setPuedoMovermeUp(boolean mov) {
		puedoMovermeUp = mov;
	}

	public boolean puedoMovermeDown() {
		return puedoMovermeDown;
	}
	
	public void setPuedoMovermeDown(boolean mov) {
		puedoMovermeDown = mov;
	}
	
	public int getVidas() {
		return vidas;
	}
	
	public void setVidas(int v) {
		vidas=v;
	}
	
	public abstract Coordenada nextPosMovDer();
	
	public abstract Coordenada nextPosMovIzq();
	
	public abstract Coordenada nextPosMovUp();
	
	public abstract Coordenada nextPosMovDown();
	
	public abstract void moverDerecha();
	
	public abstract void moverIzquierda();

	public abstract void moverArriba();
	
	public abstract void moverAbajo();
	
	/**
	 * Se encarga de reducir en uno la cantidad de vidas del personaje. Retorna Verdadero si el personaje se quedó sin
	 * vidas al reducirlas en uno (si vidas == 0, esto es, si personaje murio), falso en caso contrario.
	 * @return Verdadero si el personaje se quedó sin vidas, false en caso contrario.
	 */
	public abstract boolean perderVida();
	
	public abstract void morir();
}
