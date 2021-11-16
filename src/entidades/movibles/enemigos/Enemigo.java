package entidades.movibles.enemigos;

import entidades.movibles.EntidadMovible;
import logica.Salon;

public abstract class Enemigo extends EntidadMovible {
	protected int valor;
	protected Salon miSalon = Salon.getInstance();
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
