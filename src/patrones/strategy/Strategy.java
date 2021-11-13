package patrones.strategy;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;

public  abstract class Strategy {
	protected Jugador miJugador;
	
	public abstract void atacar(Enemigo op);

}
