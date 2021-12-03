package patrones.strategy_enem;

import entidades.movibles.EntidadMovible;

public class Asesino extends StrategyEnemy {

	@Override
	public void atacar() {
		elJugador.perderVida();
		if (elJugador.getVidas() == 0) {
			elJugador.morir();
		} else {
			elJugador.reUbicar();
		}
	}

	@Override
	public void mover(int dir) {
		switch(dir) {
		case(EntidadMovible.MOV_DER): {
			miEnemigo.moverDerecha();
			break;
		}
		case(EntidadMovible.MOV_IZQ): {
			miEnemigo.moverIzquierda();
			break;
		}
		case(EntidadMovible.MOV_UP): {
			miEnemigo.moverArriba();
			break;
		}
		case(EntidadMovible.MOV_DOWN):{
			miEnemigo.moverAbajo();
			break;
		}
		}
	}

}
