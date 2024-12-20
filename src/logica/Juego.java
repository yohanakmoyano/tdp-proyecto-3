package logica;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import entidades.Entidad;
import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.EntidadMovible;
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
	public static final int MOV_IZQUIERDA = EntidadMovible.MOV_IZQ;
	public static final int MOV_DERECHA = EntidadMovible.MOV_DER;
	public static final int MOV_ARRIBA = EntidadMovible.MOV_UP;
	public static final int MOV_ABAJO = EntidadMovible.MOV_DOWN;
	protected Movimiento movE;
	protected int dominio;

	public Juego() {
		puntos = 0;
		nivel = 1;
		miGui = Gui.getGui(this);
	}

	public Jugador getPersonaje() {
		return personaje;
	}

	public void cazarEnemigos() {
		miSala.cazarEnemigos();
	}

	public void huirDeEnemigos() {
		miSala.huirDeEnemigos();
	}

	public void setDominio(int d) {
		this.dominio = d;
		director = new Director(nivel, dominio, this);
		personaje = director.getJugador();
		miSala = director.getSalaJuego();
	}

	public int getDominio() {
		return dominio;
	}

	public Gui getGui() {
		return miGui;
	}

	public URL getMusica() {
		return director.getMusica();
	}

	public void actualizoVidas() {
		if (personaje.getVidas() != 0)
			miGui.actualizarVidas(personaje.getVidas());
		else {
			movE.setDeboMover(false);
			miGui.finDeJuego();
		}
	}

	public void setPuntaje(int p) {
		puntos = puntos + p;
		miGui.actualizarPuntaje(puntos);
	}

	public int getPuntaje() {
		return puntos;
	}

	public void actualizarFondo(String urlImg) {
		miGui.mostrarImagenFondo(urlImg, nivel);
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
		movE = new Movimiento(miSala, this);
		movE.start();
	}

	public void runEnemies() {
		movE.run();
	}

	public SalaDeJuegos getSalaDeJuegos() {
		return miSala;
	}

	public synchronized void transformarJugador() {
		if (dominio == 1)
			personaje.cambiarImagen(this.getClass().getResource("/Images/JDC/jugador_pocion.png").toString(),
					personaje.getPosicion().getX(), personaje.getPosicion().getY(), personaje.getAncho(),
					personaje.getAlto());
		if (dominio == 2)
			personaje.cambiarImagen(this.getClass().getResource("/Images/AU/jugador_red_pocion.png").toString(),
					personaje.getPosicion().getX(), personaje.getPosicion().getY(), personaje.getAncho(),
					personaje.getAlto());
		if (dominio == 3)
			personaje.cambiarImagen(this.getClass().getResource("/Images/PM/pac_man_pocion.png").toString(),
					personaje.getPosicion().getX(), personaje.getPosicion().getY(), personaje.getAncho(),
					personaje.getAlto());
		miGui.mostrarEntidad(personaje);
	}

	public synchronized void resetTransformacion() {
		if (dominio == 1)
			personaje.cambiarImagen(this.getClass().getResource("/Images/JDC/jugador_nivel1.png").toString(),
					personaje.getPosicion().getX(), personaje.getPosicion().getY(), personaje.getAncho(),
					personaje.getAlto());
		if (dominio == 2)
			personaje.cambiarImagen(this.getClass().getResource("/Images/AU/jugador_red.png").toString(),
					personaje.getPosicion().getX(), personaje.getPosicion().getY(), personaje.getAncho(),
					personaje.getAlto());
		if (dominio == 3)
			personaje.cambiarImagen(this.getClass().getResource("/Images/PM/pac_man1.png").toString(),
					personaje.getPosicion().getX(), personaje.getPosicion().getY(), personaje.getAncho(),
					personaje.getAlto());
		miGui.mostrarEntidad(personaje);
	}

	public boolean sigueEnJuego() {
		if (personaje.getVidas() >= 0)
			return true;
		else
			return false;
	}

	public void PasoDeNivel(int cantItempsUp) {
		if (cantItempsUp == miSala.getCantItems()) {
			if (nivel < 3) {
				movE.setDeboMover(false);
				SalaDeJuegos oldSala = miSala;
				List<Entidad> enemigos = oldSala.resetEnemigos();
				oldSala.resetEntidadesFijas();
				nivel = nivel + 1;
				setDominio(dominio);
				for(Entidad e: enemigos) {
					miSala.agregarEnemigoASala(e);
				}
				miGui.repaint();
				personaje.resetNivel();
				iniciarJuego();
				
			} else
				miGui.mostrarGanador();
		}
	}

	public synchronized void operar(int op, EntidadMovible e) {
		boolean puedeMover = false;
		int movARealizar = -1;
		Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
		switch (op) {
		case MOV_ABAJO: {
			puedeMover = miSala.autorizarMovAbajo(e);
			if (puedeMover) {
				e.setMovEnCola(MOV_ABAJO);
				movARealizar = e.mover();
			}
			break;
		}
		case MOV_IZQUIERDA: {
			puedeMover = miSala.autorizarMovIzquierda(e);
			if (puedeMover) {
				e.setMovEnCola(MOV_IZQUIERDA);
				movARealizar = e.mover();
			}
			break;
		}
		case MOV_DERECHA: {
			puedeMover = miSala.autorizarMovDerecha(e);
			if (puedeMover) {
				e.setMovEnCola(MOV_DERECHA);
				movARealizar = e.mover();
			}
			break;
		}
		case MOV_ARRIBA: {
			puedeMover = miSala.autorizarMovArriba(e);
			if (puedeMover) {
				e.setMovEnCola(MOV_ARRIBA);
				movARealizar = e.mover();
			}
			break;
		}
		}
		if (movARealizar != e.getUltMovimiento()) {
			e.bloquearMovimiento(movARealizar);
		}
		miSala.actualizarZonasEntidad(posAnt, e);
		miSala.detectarColisionesEntidad(posAnt, e);
	}
}