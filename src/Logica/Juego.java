package Logica;

import Entidad.Entidad;
import Entidad.Enemigo.Enemigo;
import Entidad.EntidadMovible.Personaje;
import Entidad.Item.Item;
import Entidad.Jugador.Jugador;
import Grafica.Gui;


public class Juego {

	protected int puntaje;
	protected int nivel;
	protected Gui miGui;
	protected SalaDeJuegos miSala;
	protected Director miFabrica;
	protected Personaje p;
	protected Entidad e;

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

	public boolean actualizarMovimiento(Personaje p) {
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
		if (p.getVidas() >= 0)
			return true;
		else
			return false;
	}
}
