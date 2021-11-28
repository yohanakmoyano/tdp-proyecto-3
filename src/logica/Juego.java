package logica;

import java.net.URL;

import entidades.Entidad;
import entidades.movibles.jugadores.Jugador;
import grafica.Gui;
import niveles.Director;

public class Juego {
	protected int puntos;
	protected int nivel;
	protected Gui miGui;
	protected SalaDeJuegos miSala;
	protected Director director;
	protected Jugador personaje;
	protected Entidad entidad;
	public static final int moverIzquierda = 1;
	public static final int moverDerecha = 2;
	public static final int moverAbajo = 3;
	public static final int moverArriba = 4;
	public static final int ponerItem = 5;
	protected Movimiento movE;
	protected int dominio;

	public Juego(int n) {
		puntos = 0;
		nivel = n; // 1;
		miGui = Gui.getGui(this);
		miSala = new SalaDeJuegos(this);
	}

	public void setDominio(int d) {
		this.dominio = d;
		construirDirector();
	}

	public void construirDirector() {
		director = new Director(nivel, miSala, dominio, this);
		personaje = director.getJugador();
	}

	public int getDominio() {
		return dominio;
	}

	public URL getMusica() {
		return director.getMusica();
	}

	public void actualizoVidas() {
		if (personaje.getVidas() != 0)
			miGui.actualizarVidas(personaje.getVidas());
		else
			miGui.finDeJuego();
	}

	public void setPuntaje(int p) {
		puntos = puntos + p;
		miGui.actualizarPuntaje(puntos);
	}

	public int getPuntaje() {
		return puntos;
	}

	public void actualizarFondo(String urlImg) {
		System.out.println("El url es: "+urlImg);
		miGui.mostrarImagenFondo(urlImg,nivel);
	}

	public void mostrarEntidad(Entidad e) {
		miGui.mostrarEntidad(e);
	}

	public void setNivel(int n) {
		nivel = n;
	}

	public int getNivel() {
		return nivel;
	}

	public void iniciarJuego() {
		movE = new Movimiento(miSala);
		movE.start();
		nivel = this.getNivel();
	}

	public void runEnemies() {
		movE.run();
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

	public void chequearGameOver(int cantItempsUp) {
		if(cantItempsUp==4){// (cantItempsUp == miSala.getCantItems()) {// (cantItempsUp==4){
			if (nivel < 3) {
			//	miGui.PasoDeNivel();
				miSala.reset();
				nivel = nivel + 1;
				setDominio(dominio);
			}
		personaje.resetNivel();
		}
	}
	public void setSalaDeJuegos(SalaDeJuegos s) {
		miSala=s;
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
		if (miSala.autorizarMovArriba(personaje)) {
			Coordenada posAnt = new Coordenada(personaje.getPosicion().getX(), personaje.getPosicion().getY());
			personaje.moverArriba();
			miSala.actualizarZonasEntidad(posAnt, personaje);
			miSala.detectarColisionesJugador(posAnt, personaje);
		}

	}

	private void moverDerecha() {
		if (miSala.autorizarMovDerecha(personaje)) {
			Coordenada posAnt = new Coordenada(personaje.getPosicion().getX(), personaje.getPosicion().getY());
			personaje.moverDerecha();
			miSala.actualizarZonasEntidad(posAnt, personaje);
			miSala.detectarColisionesJugador(posAnt, personaje);
		}
	}

	private void moverIzquierda() {
		if (miSala.autorizarMovIzquierda(personaje)) {
			Coordenada posAnt = new Coordenada(personaje.getPosicion().getX(), personaje.getPosicion().getY());
			personaje.moverIzquierda();
			miSala.actualizarZonasEntidad(posAnt, personaje);
			miSala.detectarColisionesJugador(posAnt, personaje);
		}
	}

	private void moverAbajo() {
		if (miSala.autorizarMovAbajo(personaje)) {
			Coordenada posAnt = new Coordenada(personaje.getPosicion().getX(), personaje.getPosicion().getY());
			personaje.moverAbajo();
			miSala.actualizarZonasEntidad(posAnt, personaje);
			miSala.detectarColisionesJugador(posAnt, personaje);
		}

	}
}