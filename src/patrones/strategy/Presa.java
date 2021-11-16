package patrones.strategy;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;

public class Presa extends Strategy {

	public Presa(Jugador j) {
		miJugador = j;
	}
	
	@Override
	public void atacar(Enemigo op) {
		miJugador.perderVida(); /**
		if(miJugador.getVidas() == 0) {
			//miJugador.morir(); //Resolver el morir
		} else {
			miJugador.morir();
		}**/
		miJugador.morir();//Corregir
	}

}
