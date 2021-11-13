package entidades.movibles.jugadores;

import entidades.movibles.Personaje;
import patrones.strategy.ControlStrategy;

public abstract class Jugador extends Personaje {
	protected ControlStrategy controlStr;
	
	public ControlStrategy getEstrategia() {
		return controlStr;
	}
	
	public abstract void moverDerecha();
	
	public abstract void moverIzquierda();

	public abstract void moverArriba();
	
	public abstract void moverAbajo();
	
	/**
	 * Por el momento hace una especie de switch entre las dos estrategias existentes.
	 * Ver como hacer para que esto no dependa de que solo existen dos estrategias.
	 */
	public void cambiarEstrategia() {
		
	}
	
}
