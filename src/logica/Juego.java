package logica;

import java.net.URL;
import java.util.AbstractSet;
import java.util.HashSet;

import entidades.Entidad;
import entidades.movibles.EntidadMovible;
import entidades.movibles.jugadores.Jugador;
import grafica.Gui;
import logica.hilos.EnemiesThread;
import logica.hilos.JugadorThread;
import niveles.Director;

public class Juego {
	
	protected JugadorThread hiloJug;
	protected EnemiesThread hiloEnemies;
	
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
	}
	
	/**
	 * Este método debe ser llamado dentro de iniciarJuego.
	 */
	protected void prepararHiloJugador() {
		hiloJug = new JugadorThread();
		hiloJug.setSalaDeJuegos(miSala);
		AbstractSet<EntidadMovible> jug = new HashSet<EntidadMovible>();
		jug.add(personaje);
		hiloJug.setEntidad(jug);
	}

	public JugadorThread getHiloJugador() {
		return hiloJug;
	}

	/**
	 * Este método debe ser llamado dentro de iniciarJuego.
	 */
	protected void prepararHiloEnemies() {
		hiloEnemies = new EnemiesThread();
		hiloEnemies.setJugador(personaje);
		hiloEnemies.setSalaDeJuegos(miSala);
		AbstractSet<EntidadMovible> enem = new HashSet<EntidadMovible>();
		for(Entidad e : miSala.getListaEnemigos()) {
			enem.add((EntidadMovible)e);
		}
		hiloEnemies.setEntidad(enem);
	}
	
	public EnemiesThread getHiloEnemies() {
		return hiloEnemies;
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
	public void TransformarJugador() {
			if (dominio==1)
				personaje.cambiarImagen(this.getClass().getResource("/Images/JDC/jugador_pocion.png").toString(),personaje.getPosicion().getX(),personaje.getPosicion().getY(),personaje.getAlto(),personaje.getAlto());
			if (dominio==2)
				personaje.cambiarImagen(this.getClass().getResource("/Images/AU/jugador_red_pocion.png").toString(),personaje.getPosicion().getX(),personaje.getPosicion().getY(),personaje.getAlto(),personaje.getAlto());
			if (dominio==3)
				personaje.cambiarImagen(this.getClass().getResource("/Images/PM/pac_man_pocion.png").toString(),personaje.getPosicion().getX(),personaje.getPosicion().getY(),personaje.getAlto(),personaje.getAlto());
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
	
	public void chequearGameOver(int cantItempsUp) {
		if(cantItempsUp==1000){//(cantItempsUp == miSala.getCantItems()) {// (cantItempsUp==4){
			if (nivel < 3) {
				miGui.PasoDeNivel();
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
	

	public synchronized void operar(int op) {
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
			miSala.detectarColisionesEntidad(posAnt, personaje);
		}

	}

	private void moverDerecha() {
		if (miSala.autorizarMovDerecha(personaje)) {
			Coordenada posAnt = new Coordenada(personaje.getPosicion().getX(), personaje.getPosicion().getY());
			personaje.moverDerecha();
			miSala.actualizarZonasEntidad(posAnt, personaje);
			miSala.detectarColisionesEntidad(posAnt, personaje);
		}
	}

	private void moverIzquierda() {
		if (miSala.autorizarMovIzquierda(personaje)) {
			Coordenada posAnt = new Coordenada(personaje.getPosicion().getX(), personaje.getPosicion().getY());
			personaje.moverIzquierda();
			miSala.actualizarZonasEntidad(posAnt, personaje);
			miSala.detectarColisionesEntidad(posAnt, personaje);
		}
	}

	private void moverAbajo() {
		if (miSala.autorizarMovAbajo(personaje)) {
			Coordenada posAnt = new Coordenada(personaje.getPosicion().getX(), personaje.getPosicion().getY());
			personaje.moverAbajo();
			miSala.actualizarZonasEntidad(posAnt, personaje);
			miSala.detectarColisionesEntidad(posAnt, personaje);
		}

	} 
}