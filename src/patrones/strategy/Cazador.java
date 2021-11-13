package patrones.strategy;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;

public class Cazador extends Strategy{

	public Cazador(Jugador j) {
		miJugador = j;
	}
	
	@Override
	public void atacar(Enemigo op) {
		// TODO Auto-generated method stub
		op.morir();
		miJugador.afectarPuntaje(op.getValor());
	}

}
