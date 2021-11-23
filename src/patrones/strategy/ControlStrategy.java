package patrones.strategy;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;

public class ControlStrategy {
	protected Strategy estrategia;

	public ControlStrategy(Jugador jug) {
		estrategia = new Presa(jug);
	}

	public void setStrategy(Strategy est) {
		estrategia = est;
	}

	public void atacar(Enemigo op) {
		estrategia.atacar(op);
	}
}
