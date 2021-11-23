package logica;

import java.util.Random;

import entidades.Entidad;
import entidades.movibles.enemigos.Enemigo;

public class Movimiento extends Thread {
	protected SalaDeJuegos sala;
	protected boolean deboMover;
	protected Random ran;

	public Movimiento(SalaDeJuegos sj) {
		sala = sj;
		deboMover = true;
		ran = new Random();
	}

	public void run() {
		while (deboMover) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			moverEnemigos();
		}
	}

	public boolean getDeboMover() {
		return deboMover;
	}

	public void setDeboMover(boolean deboMover) {
		this.deboMover = deboMover;
	}

	protected void moverEnemigos() {
		for (Entidad e : sala.getListaEnemigos()) {
			int mov = ran.nextInt(4);
			moverMientrasPueda((Enemigo) e, mov);
		}
	}

	protected void moverMientrasPueda(Enemigo e, int direccion) {
		switch (direccion) {
		case (0): {
			moverEnemigoDer(e);
			break;
		}
		case (1): {
			moverEnemigoIzq(e);
			break;
		}
		case (2): {
			moverEnemigoUp(e);
			break;
		}
		case (3): {
			moverEnemigoDown(e);
			break;
		}
		}
	}

	protected void moverEnemigoDer(Enemigo e) {
		if (sala.autorizarMovDerecha(e)) {
			Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
			e.moverDerecha();
			sala.actualizarZonasEntidad(posAnt, e);
			sala.detectarColisionesJugador(posAnt, e);
		}
	}

	protected void moverEnemigoIzq(Enemigo e) {
		if (sala.autorizarMovIzquierda(e)) {
			Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
			e.moverIzquierda();
			sala.actualizarZonasEntidad(posAnt, e);
			sala.detectarColisionesJugador(posAnt, e);
		}
	}

	protected void moverEnemigoUp(Enemigo e) {
		if (sala.autorizarMovArriba(e)) {
			Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
			e.moverArriba();
			sala.actualizarZonasEntidad(posAnt, e);
			sala.detectarColisionesJugador(posAnt, e);
		}
	}

	protected void moverEnemigoDown(Enemigo e) {
		if (sala.autorizarMovAbajo(e)) {
			Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
			e.moverAbajo();
			sala.actualizarZonasEntidad(posAnt, e);
			sala.detectarColisionesJugador(posAnt, e);
		}
	}

}
