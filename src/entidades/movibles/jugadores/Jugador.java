package entidades.movibles.jugadores;

import entidades.movibles.Personaje;

public abstract class Jugador extends Personaje {
	
	public abstract void moverDerecha();
	
	public abstract void moverIzquierda();

	public abstract void moverArriba();
	
	public abstract void moverAbajo();
	
}
