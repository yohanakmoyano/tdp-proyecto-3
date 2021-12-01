package logica.hilos;

import java.util.AbstractSet;

import entidades.movibles.EntidadMovible;
import logica.Coordenada;
import logica.Juego;
import logica.SalaDeJuegos;

public abstract class EntidadMovibleThread extends Thread {
	protected AbstractSet<EntidadMovible> entidadesMovibles;  //Cuando esté en el hilo del jugador
	protected SalaDeJuegos miSala;								//este conjunto solo tendrá almacenado al jugador
														//En el caso de los enemigos tendrá a los enemigos que existan en el juego.

	public abstract void preparar();
	
	public abstract void iniciar();

	public AbstractSet<EntidadMovible> getEntidad() {
		return entidadesMovibles;
	}
	
	public void setEntidad(AbstractSet<EntidadMovible> ent) {
		entidadesMovibles = ent;
	}
	
	public SalaDeJuegos getSalaDeJuegos() {
		return miSala;
	}
	
	public void setSalaDeJuegos(SalaDeJuegos sj) {
		miSala = sj;
	}
	
	protected void moverArriba(EntidadMovible entidad) {
		if (miSala.autorizarMovArriba(entidad)) {
			Coordenada posAnt = new Coordenada(entidad.getPosicion().getX(), entidad.getPosicion().getY());
			entidad.moverArriba();
			miSala.actualizarZonasEntidad(posAnt, entidad);
			miSala.detectarColisionesEntidad(posAnt, entidad);
		}

	}

	protected void moverDerecha(EntidadMovible entidad) {
		if (miSala.autorizarMovDerecha(entidad)) {
			Coordenada posAnt = new Coordenada(entidad.getPosicion().getX(), entidad.getPosicion().getY());
			entidad.moverDerecha();
			miSala.actualizarZonasEntidad(posAnt, entidad);
			miSala.detectarColisionesEntidad(posAnt, entidad);
		}
	}

	protected void moverIzquierda(EntidadMovible entidad) {
		if (miSala.autorizarMovIzquierda(entidad)) {
			Coordenada posAnt = new Coordenada(entidad.getPosicion().getX(), entidad.getPosicion().getY());
			entidad.moverIzquierda();
			miSala.actualizarZonasEntidad(posAnt, entidad);
			miSala.detectarColisionesEntidad(posAnt, entidad);
		}
	}

	protected void moverAbajo(EntidadMovible entidad) {
		if (miSala.autorizarMovAbajo(entidad)) {
			Coordenada posAnt = new Coordenada(entidad.getPosicion().getX(), entidad.getPosicion().getY());
			entidad.moverAbajo();
			miSala.actualizarZonasEntidad(posAnt, entidad);
			miSala.detectarColisionesEntidad(posAnt, entidad);
		}
	}
}
