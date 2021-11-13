package entidades.movibles;

import entidades.Entidad;

public abstract class EntidadMovible extends Entidad {
	protected int velocidad;
	protected int vidas;

	public int getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(int vel) {
		velocidad = vel;
	}
	
	public int getVidas() {
		return vidas;
	}
	
	public void setVidas(int v) {
		vidas=v;
	}
	
	/**
	 * Se encarga de reducir en uno la cantidad de vidas del personaje. Retorna Verdadero si el personaje se quedó sin
	 * vidas al reducirlas en uno (si vidas == 0, esto es, si personaje murio), falso en caso contrario.
	 * @return Verdadero si el personaje se quedó sin vidas, false en caso contrario.
	 */
	public abstract boolean perderVida();
	
	public abstract void morir();
}
