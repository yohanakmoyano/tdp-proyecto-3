package Logica;

import Entidad.Item;
import Entidad.Personaje;

public class Juego {
	
	private int puntaje;
	private int nivel;
	
	public Juego() {
		puntaje=0;
		nivel=1;
	}
	
	public void setPuntaje(int p) {
		puntaje=p;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setNivel(int n) {
		puntaje=n;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void generarEnemigos() {
		
	}
	
	public void generarItems() {
		
	}
	
	public void inicializarJuego() {
		
	}
	
	public void actualizarSalaDeJuego(SalaDeJuegos s){
		
	}
	
	public void cambioEstadoItem(Item item) {
		
	}
	
	public void cambioEstadoGuaria(Guardia guardia) {
		
	}
	
	public void cambioEstadoJuegador(Jugador_456 jugador) {
		
	}
	
	public boolean actualizarMovimiento(Personaje p) {
		
	}
}
