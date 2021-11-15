package logica;

import entidades.Entidad;
import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.Item;
import grafica.Gui;
import patrones.level_builder.Director;


public class Juego {
	protected Puntaje puntos;
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
		puntos = Puntaje.getInstancePuntaje();
		nivel = 1;
		miGui = mg;
		miGui.setVisible(true);
		miSala = new SalaDeJuegos(mg,this);
		miFabrica = new Director(nivel, miSala);
		if(!miSala.getListJugador().isEmpty())
			personaje = (Jugador) miSala.getListJugador().get(0);
	}	
	
	public void setPuntaje(int p) {
		puntos.setPuntaje(p);
	}

	public int getPuntaje() {
		return puntos.getPuntajeActual();
	}

	public void setNivel(int n) {
		nivel = n;
	}

	public int getNivel() {
		// return nivel;
		// return 3;
		// return 2;
		return 1;
	}

	public void iniciarJuego() {
		//puntaje = 0;
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
		System.out.println("--------------------------Logica-------------------------------------------------------------");
		System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		if(miSala.autorizarMovArriba(personaje)) {
			personaje.moverArriba();
			miSala.actualizarZonasEntidad(personaje);
			miSala.detectarColisionesJugador(personaje);
			System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		}
		
	}

	private void moverDerecha() {
		System.out.println("--------------------------Logica-------------------------------------------------------------");
		System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		if(miSala.autorizarMovDerecha(personaje)) {
			personaje.moverDerecha();
			miSala.actualizarZonasEntidad(personaje);
			miSala.detectarColisionesJugador(personaje);
			System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		
	}

	private void moverIzquierda() {
		System.out.println("--------------------------Logica-------------------------------------------------------------");
		System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		if(miSala.autorizarMovIzquierda(personaje)) {
			personaje.moverIzquierda(); 
			miSala.actualizarZonasEntidad(personaje);
			miSala.detectarColisionesJugador(personaje);
			System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		
	}

	private void moverAbajo() {
		System.out.println("--------------------------Logica-------------------------------------------------------------");
		System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		if(miSala.autorizarMovAbajo(personaje)) {
			personaje.moverAbajo(); 
			miSala.actualizarZonasEntidad(personaje);
			miSala.detectarColisionesJugador(personaje);
			System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		}
		System.out.println("-----------------------------------------------------------------------------------------------");
		
	}
	
}
