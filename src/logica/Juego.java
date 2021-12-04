package logica;

import java.net.URL;
import entidades.Entidad;
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
	public static final int PONER_ITEM = 5;
	protected Movimiento movE;
	protected int dominio;

	public Juego(int n) {
		puntos = 0;
		nivel = n; // 1;
		miGui = Gui.getGui(this);
	}
	
	public Jugador getPersonaje() {
		return personaje;
	}
	
	
	public void setDominio(int d) {
		this.dominio = d;
		construirDirector();
		miSala = director.getSalaJuego();
	}

	public void construirDirector() {
		director = new Director(nivel, dominio, this);
		personaje = director.getJugador();
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
	/*public void actualizarposRespawn(Coordenada p) {
		personaje.setposRespawn(p);
	}*/
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
		//this.prepararHiloJugador();
		movE = new Movimiento(miSala, this);
		movE.start();
		//this.prepararHiloEnemies();
		//hiloEnemies.preparar();
		//hiloEnemies.iniciar();
		nivel = this.getNivel();
	}

	public void runEnemies() {
		movE.run();
	}

	public SalaDeJuegos getSalaDeJuegos() {
		return miSala;
	}
	
	public void transformarJugador() {
		
		if (dominio == 1)
			personaje.cambiarImagen(this.getClass().getResource("/Images/JDC/jugador_pocion.png").toString(), personaje.getPosicion().getX(), personaje.getPosicion().getY(), personaje.getAncho(), personaje.getAlto());
		if (dominio == 2)
			personaje.cambiarImagen(this.getClass().getResource("/Images/AU/jugador_red_pocion.png").toString(), personaje.getPosicion().getX(), personaje.getPosicion().getY(), personaje.getAncho(), personaje.getAlto());
		if (dominio == 3)
			personaje.cambiarImagen(this.getClass().getResource("/Images/PM/pac_man_pocion.png").toString(), personaje.getPosicion().getX(), personaje.getPosicion().getY(), personaje.getAncho(), personaje.getAlto());
		miGui.mostrarEntidad(personaje);
	}
	
	public void resetTransformacion() {
	
		if (dominio == 1)
			personaje.cambiarImagen(this.getClass().getResource("/Images/JDC/jugador_nivel1.png").toString(), personaje.getPosicion().getX(), personaje.getPosicion().getY(), personaje.getAncho(), personaje.getAlto());
		if (dominio == 2)
			personaje.cambiarImagen(this.getClass().getResource("/Images/AU/jugador_red.png").toString(), personaje.getPosicion().getX(), personaje.getPosicion().getY(), personaje.getAncho(), personaje.getAlto());
		if (dominio == 3)
			personaje.cambiarImagen(this.getClass().getResource("/Images/PM/pac_man1.png").toString(), personaje.getPosicion().getX(), personaje.getPosicion().getY(), personaje.getAncho(), personaje.getAlto());
		miGui.mostrarEntidad(personaje);
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
	
	public void PasoDeNivel(int cantItempsUp) {
		if(cantItempsUp == miSala.getCantItems()){//(cantItempsUp == miSala.getCantItems()) {// (cantItempsUp==4){
			if (nivel < 3) {
				miSala.reset();
				nivel = nivel + 1;
				setDominio(dominio);
				miGui.repaint();
				personaje.resetNivel();
			}
		else
			miGui.mostrarGanador();
		}
	}
	public void setSalaDeJuegos(SalaDeJuegos s) {
		miSala=s;
	}

	public synchronized void operar(int op, EntidadMovible e) {
		boolean puedeMover = false;
		int movARealizar = -1;
		Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
		switch (op) {
		case MOV_ABAJO: {
			puedeMover = miSala.autorizarMovAbajo(e);
			if(puedeMover) {
				e.setMovEnCola(MOV_ABAJO);
				movARealizar = e.mover();
				//moverAbajo(e);
			}
			break;
		}
		case MOV_IZQUIERDA: {
			puedeMover = miSala.autorizarMovIzquierda(e);
			if(puedeMover) {
				e.setMovEnCola(MOV_IZQUIERDA);
				movARealizar = e.mover();
				//moverIzquierda(e);
			}
			break;
		}
		case MOV_DERECHA: {
			puedeMover = miSala.autorizarMovDerecha(e);
			if(puedeMover) {
				e.setMovEnCola(MOV_DERECHA);
				movARealizar = e.mover();
				//moverDerecha(e);
			}
			break;
		}
		case MOV_ARRIBA: {
			puedeMover = miSala.autorizarMovArriba(e);
			if(puedeMover) {
				e.setMovEnCola(MOV_ARRIBA);
				movARealizar = e.mover();
				//moverArriba(e);
			}
			break;
		}
		}
		if(movARealizar != e.getUltMovimiento()) { //Si colisiono con un bloque esto dara verdadero.
			e.bloquearMovimiento(movARealizar);
		}
		miSala.actualizarZonasEntidad(posAnt, e);
		miSala.detectarColisionesEntidad(posAnt, e);
	}
/**
	private void moverArriba(EntidadMovible e) {
		if (miSala.autorizarMovArriba(e)) {
			Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
			e.moverArriba();
			miSala.actualizarZonasEntidad(posAnt, e);
			miSala.detectarColisionesEntidad(posAnt, e);
		}

	}

	private void moverDerecha(EntidadMovible e) {
		if (miSala.autorizarMovDerecha(e)) {
			Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
			e.moverDerecha();
			miSala.actualizarZonasEntidad(posAnt, e);
			miSala.detectarColisionesEntidad(posAnt, e);
		}
	}

	private void moverIzquierda(EntidadMovible e) {
		if (miSala.autorizarMovIzquierda(e)) {
			Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
			e.moverIzquierda();
			miSala.actualizarZonasEntidad(posAnt, e);
			miSala.detectarColisionesEntidad(posAnt, e);
		}
	}

	private void moverAbajo(EntidadMovible e) {
		if (miSala.autorizarMovAbajo(e)) {
			Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
			e.moverAbajo();
			miSala.actualizarZonasEntidad(posAnt, e);
			miSala.detectarColisionesEntidad(posAnt, e);
		}

	} */
}