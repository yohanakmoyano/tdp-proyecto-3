package entidades.movibles.enemigos;

import entidades.movibles.EntidadMovible;
import logica.Salon;

public abstract class Enemigo extends EntidadMovible {
	protected int valor;
	protected Salon miSalon = Salon.getInstance();
	public static final int ejeX = 0;
	public static final int ejeY = 1;	
	
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
