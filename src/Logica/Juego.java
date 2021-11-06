package Logica;

import Entidad.Entidad;
import Entidad.Enemigo.Enemigo;
import Entidad.EntidadMovible.Personaje;
import Entidad.Item.Energizante;
import Entidad.Item.Item;
import Entidad.Jugador.Jugador;
import Grafica.Gui;


public class Juego {
	
	protected int puntaje;
	protected int nivel;
	protected Gui miGui;
	protected SalaDeJuegos misala;
	protected Director miFabrica;
	protected Personaje p;
	protected Entidad e;
	
	public Juego() {
		puntaje=0;
		nivel=1;
		miFabrica=new Director(nivel);
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
		//return nivel;
		//return 3;
		//return 2;
		return 1;
	}
	
	public void generarEnemigos() {
		
	}
	
	public void generarItems() {
		Entidad energizante=new Energizante(1,new Coordenada(451,137)); 
		
		
	}
	
	public void iniciarJuego() {
		puntaje=0;
		nivel=1;
	}
	
	public void actualizarSalaDeJuego(SalaDeJuegos s){
		
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
		return misala;
	}
	private void finDeJuego() {
			miGui.finDeJuego();	
	}
	public boolean sigueEnJuego() {
		if(p.getVidas()>=0)
			return true;
		else
			return false;
	}
}
