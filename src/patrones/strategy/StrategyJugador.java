package patrones.strategy;

import entidades.movibles.enemigos.Enemigo;

public abstract class StrategyJugador {
	protected Strategy estrategia;
	
	public void setStrategy(Strategy est) {
		estrategia = est;
	}
	public void atacar(Enemigo op) {
		
	}
}
