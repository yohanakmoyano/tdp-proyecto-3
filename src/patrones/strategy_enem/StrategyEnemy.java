package patrones.strategy_enem;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;

public abstract class StrategyEnemy {
	protected Jugador elJugador;
	protected Enemigo miEnemigo;
	
	public void setJugador(Jugador jug) {
		elJugador = jug;
	}
	
	public void setEnemigo(Enemigo e) {
		miEnemigo = e;
	}
	
	public abstract void atacar();
	
	public abstract void mover(int dir);
}
