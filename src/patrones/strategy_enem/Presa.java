package patrones.strategy_enem;

import entidades.movibles.EntidadMovible;

public class Presa extends StrategyEnemy{

	@Override
	public void atacar() {
		miEnemigo.morir();
		elJugador.afectarPuntaje(miEnemigo.getValor());
	}

	@Override
	//En modo presa se mueve en sentido contrario a como se quiere mover.
	public void mover(int dir) {
		switch(dir) {
		case(EntidadMovible.MOV_DER): {
			miEnemigo.moverIzquierda();
			break;
		}
		case(EntidadMovible.MOV_IZQ): {
			miEnemigo.moverDerecha();
			break;
		}
		case(EntidadMovible.MOV_UP): {
			miEnemigo.moverAbajo();
			break;
		}
		case(EntidadMovible.MOV_DOWN):{
			miEnemigo.moverArriba();
			break;
		}
		}
	}

}
