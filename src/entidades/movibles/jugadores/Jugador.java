package entidades.movibles.jugadores;

import entidades.movibles.EntidadMovible;
import patrones.strategy.ControlStrategy;

public abstract class Jugador extends EntidadMovible {
	protected ControlStrategy controlStr;
	
	public ControlStrategy getEstrategia() {
		return controlStr;
	}
	
	/**
	 * Por el momento hace una especie de switch entre las dos estrategias existentes.
	 * Ver como hacer para que esto no dependa de que solo existen dos estrategias.
	 */
	public void cambiarEstrategia() {
		
	}
	
}
