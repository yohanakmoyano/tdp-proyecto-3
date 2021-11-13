package patrones.strategy;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;

public class Presa extends Strategy {

	public Presa(Jugador j) {
		miJugador = j;
	}
	
	@Override
	public void atacar(Enemigo op) {
		// TODO Auto-generated method stub
		boolean murio = miJugador.perderVida();
		if(murio)
			miJugador.morir();
	}

}
