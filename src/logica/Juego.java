package logica;


import entidades.Entidad;
import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.EntidadNoMovible;
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
	public static final int ponerItem = 5;
	protected Movimiento movE;
	protected int d;
	public Juego() {
		puntos = Puntaje.getInstancePuntaje();
		nivel = 1;
		miGui = Gui.getGui(this);
		miSala = new SalaDeJuegos(miGui,this);
	    /*miFabrica = new Director(nivel, miSala,d);
		if(!miSala.getListJugador().isEmpty())
			personaje = (Jugador) miSala.getListJugador().get(0);*/
	}	
	public void setDominio(int d) {
		miFabrica = new Director(nivel, miSala,d);
		if(!miSala.getListJugador().isEmpty())
			personaje = (Jugador) miSala.getListJugador().get(0);
	}
	public void actualizoVidas() {
		if (personaje.getVidas()!=0)
		miGui.actualizarVidas(personaje.getVidas());
		else
			miGui.finDeJuego();
	}
	
	public void setPuntaje(int p) {
		puntos.setPuntaje(p);
	}

	public int getPuntaje() {
		int toRet;
		toRet=puntos.getPuntajeActual();
		
		if (toRet==100) //358
			miGui.PasoDeNivel();
		return toRet;
	}

	public void setNivel(int n) {
		nivel = n;
	}

	public int getNivel() {
		 return nivel;
	}

	public void iniciarJuego() {
		//puntaje = 0;
		movE = new Movimiento(miSala);
		movE.start();
		nivel = 1;
	}
	public void runEnemies() {
		movE.run();
	}
	
	//falta coneccion entre el jugador
	public void agregarItemD() {
		miGui.agregarItem();
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
			personaje.moverArriba();
			miSala.actualizarZonasEntidad(personaje);
			miSala.detectarColisionesJugador(personaje);
			//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		}
		
	}

	private void moverDerecha() {
		//System.out.println("--------------------------Logica-------------------------------------------------------------");
		//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		if(miSala.autorizarMovDerecha(personaje)) {
			personaje.moverDerecha();
			miSala.actualizarZonasEntidad(personaje);
			miSala.detectarColisionesJugador(personaje);
			//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		}
		//System.out.println("-----------------------------------------------------------------------------------------------");
		
	}

	private void moverIzquierda() {
		//System.out.println("--------------------------Logica-------------------------------------------------------------");
		//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		if(miSala.autorizarMovIzquierda(personaje)) {
			personaje.moverIzquierda(); 
			miSala.actualizarZonasEntidad(personaje);
			miSala.detectarColisionesJugador(personaje);
			//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		}
		//System.out.println("-----------------------------------------------------------------------------------------------");
		
	}

	private void moverAbajo() {
		//System.out.println("--------------------------Logica-------------------------------------------------------------");
		//System.out.println("Coordenada jugador: ("+personaje.getEsquinaSupIzq().getX()+", "+personaje.getEsquinaSupIzq().getY()+")");
		if(miSala.autorizarMovAbajo(personaje)) {
			personaje.moverAbajo(); 
			miSala.actualizarZonasEntidad(personaje);
			miSala.detectarColisionesJugador(personaje);
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
