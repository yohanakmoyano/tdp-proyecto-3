package entidades.movibles.enemigos;

import entidades.movibles.EntidadMovible;

public abstract class Enemigo extends EntidadMovible {
	protected int valor;

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getValor() {
		return valor;
	}

}
