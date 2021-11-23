package logica;

import java.net.URL;
import entidades.Entidad;
import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.EntidadNoMovible;
import grafica.Gui;
import niveles.Director;

public class Juego{
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
		nivel = n; //1;
		miGui = Gui.getGui(this);
		miSala = new SalaDeJuegos(this);
	}	
	
	public void setDominio(int d) {
		this.dominio=d;
		construirDirector();
	}
	public void construirDirector() {
		System.out.println("mi nivel es: "+nivel);
		System.out.println("mi dominio es: "+dominio);
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
		if (personaje.getVidas()!=0) 
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
		System.out.println("la ruta es ACAAAAA "+urlImg);
		miGui.mostrarImagenFondo(urlImg);
	}
	
	public void mostrarEntidad(Entidad e) {
		miGui.mostrarEntidad(e);
	}
	
	public void setNivel(int n) {
		nivel = n;
		//setDominio(dominio);
	}

	public int getNivel() {
		 return nivel;
	}

	public void iniciarJuego() {
		//puntaje = 0;
		movE = new Movimiento(miSala);
		movE.start();
		nivel = this.getNivel();
	}
	//cuando inicio el juego no incio el enemigo tambien??
	public void runEnemies() {
		movE.run();
	}
	
	public void actualizarSalaDeJuego(SalaDeJuegos s) {

	}

	public void cambioEstadoItem(EntidadNoMovible item) {

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
	
	public void chequearGameOver(int cantItempsUp) {
	  if(cantItempsUp == miSala.getCantItems() ) {//(cantItempsUp==4){
			if(nivel < 3) {
				nivel=nivel+1;
				//setNivel(nivel+1);
				setDominio(dominio);
				miGui.PasoDeNivel();
			}
			else {
				terminoElJuego();
			}
		}
	}

	//cree el menu devuelta
	public void terminoElJuego() {
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
			case ponerItem: {
				ponerItem();
				break;
			}
		}
	}


	private void moverArriba() {
		//System.out.println("--------------------------Logica-------------------------------------------------------------");
		//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		if(miSala.autorizarMovArriba(personaje)) {
			Coordenada posAnt = new Coordenada(personaje.getPosicion().getX(), personaje.getPosicion().getY());
			personaje.moverArriba();
			miSala.actualizarZonasEntidad(posAnt, personaje);
			miSala.detectarColisionesJugador(posAnt, personaje);
			//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		}
		
	}

	private void moverDerecha() {
		//System.out.println("--------------------------Logica-------------------------------------------------------------");
		//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		if(miSala.autorizarMovDerecha(personaje)) {
			Coordenada posAnt = new Coordenada(personaje.getPosicion().getX(), personaje.getPosicion().getY());
			personaje.moverDerecha();
			miSala.actualizarZonasEntidad(posAnt, personaje);
			miSala.detectarColisionesJugador(posAnt, personaje);
			//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		}
		//System.out.println("-----------------------------------------------------------------------------------------------");
		
	}

	private void moverIzquierda() {
		//System.out.println("--------------------------Logica-------------------------------------------------------------");
		//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		if(miSala.autorizarMovIzquierda(personaje)) {
			Coordenada posAnt = new Coordenada(personaje.getPosicion().getX(), personaje.getPosicion().getY());
			personaje.moverIzquierda(); 
			miSala.actualizarZonasEntidad(posAnt, personaje);
			miSala.detectarColisionesJugador(posAnt, personaje);
			//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		}
		//System.out.println("-----------------------------------------------------------------------------------------------");
		
	}

	private void moverAbajo() {
		//System.out.println("--------------------------Logica-------------------------------------------------------------");
		//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		if(miSala.autorizarMovAbajo(personaje)) {
			Coordenada posAnt = new Coordenada(personaje.getPosicion().getX(), personaje.getPosicion().getY());
			personaje.moverAbajo(); 
			miSala.actualizarZonasEntidad(posAnt, personaje);
			miSala.detectarColisionesJugador(posAnt, personaje);
			//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		}
	//	System.out.println("-----------------------------------------------------------------------------------------------");
		
	}
	//si toque la tecla en esa posicion del jugador dejo la bomba
	private void ponerItem() {
		if(personaje.tieneItemD()) {
			if(miSala.autorizarMovAbajo(personaje));
			
		}
	}
}
