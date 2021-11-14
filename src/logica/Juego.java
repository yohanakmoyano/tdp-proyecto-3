package logica;

import entidades.Entidad;
import entidades.movibles.EntidadMovible;
import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import entidades.movibles.jugadores.Jugador_456;
import entidades.nomovibles.Item;
import grafica.Gui;
import patrones.level_builder.Director;


public class Juego {

	protected int puntaje;
	protected int nivel;
	protected Gui miGui;
	protected SalaDeJuegos miSala;
	protected Director miFabrica;
	protected Jugador personaje;
	protected Entidad entidad;
	public static final int moverIzquierda = 1;
	public static final int moverDerecha = 2;
	public static final int moverAbajo = 3;
	public static final int moverArriba = 4;

	public Juego(Gui mg) {
		puntaje = 0;
		nivel = 1;
		miGui = mg;
		miGui.setVisible(true);
		miSala = new SalaDeJuegos(mg,this);
		miFabrica = new Director(nivel, miSala);
		
	}

	public void setPuntaje(int p) {
		puntaje = p;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setNivel(int n) {
		puntaje = n;
	}

	public int getNivel() {
		// return nivel;
		// return 3;
		// return 2;
		return 1;
	}

	/*
	 * public void generarEnemigos() {
	 * 
	 * }
	 * 
	 * public void generarItems() {
	 * 
	 * 
	 * 
	 * }
	 */

	public void iniciarJuego() {
		puntaje = 0;
		nivel = 1;
	}

	public void actualizarSalaDeJuego(SalaDeJuegos s) {

	}

	public void cambioEstadoItem(Item item) {

	}

	public void cambioEstadoEnemigo(Enemigo enem) {

	}

	public void cambioEstadoJugador(Jugador jugador) {

	}

	public boolean actualizarMovimiento(EntidadMovible p) {
		return false;
	}

	public SalaDeJuegos getSalaDeJuegos() {
		return miSala;
	}

	@SuppressWarnings("unused")
	private void finDeJuego() {
		miGui.finDeJuego();
	}

	public boolean sigueEnJuego() {
		if (personaje.getVidas() >= 0)
			return true;
		else
			return false;
	}
	

	public void operar(int op) {
		switch (op) {
		case moverAbajo: {
			moverAbajo();
			break;
		}
		case moverIzquierda: {
			moverIzquierda();
			break;
		}
		case moverDerecha: {
			moverDerecha();
			break;
		}
		case moverArriba: {
			moverArriba();
			break;
		}
		}
	}

	private void moverArriba() {
		personaje.moverArriba();
		
	}

	private void moverDerecha() {
		personaje.moverDerecha();
		
	}

	private void moverIzquierda() {
		personaje.moverIzquierda();
		
	}

	private void moverAbajo() {
		personaje.moverAbajo();
		
	}
	
}
