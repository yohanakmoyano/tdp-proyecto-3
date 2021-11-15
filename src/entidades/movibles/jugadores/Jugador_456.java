package entidades.movibles.jugadores;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.strategy.ControlStrategy;
import patrones.visitor_entidad.VisitorEntidad;
import patrones.visitor_entidad.VisitorJugador;

public class Jugador_456 extends Jugador {
	protected static Jugador_456 myInstance;

	// TODO
	/**Dado que tira error al momento de crear los niveles, por ahora dejaré este constructor público.
	//Evitando así posibles errores al modificar esas lineas.
	//Una vez solucionado eso, pasar el constructor a privado.**/
	public Jugador_456(Coordenada c, int vel, int v, String rutaImg) {
		miVisitor = new VisitorJugador(this);
		velocidad = vel;
		vidas = v;
		posicion = c;
		ancho = 23;
		alto = 28;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
		controlStr = new ControlStrategy(this); //Por defecto se crea con estrategia presa.
	}
	
	private Jugador_456() {
		// TODO acá llamar al constructor Jugador_456(Coordenada c, int vel, int v, String rutaImg) con
		//		los parámetros adecuados.
	}
	
	public static Jugador getJugador() {
		if(myInstance == null)
			myInstance = new Jugador_456();
		return myInstance;
	}
	
	
	//se mueve + en el eje x
	public void moverDerecha() {
		actualizarMov = posicion.getX() + (ancho/2);
		posicion.setX(actualizarMov);
		miRep.moverDerecha();
	}
	
	//se mueve - en el eje x
	public void moverIzquierda() {
		actualizarMov = posicion.getX() - (ancho/2);
		posicion.setX(actualizarMov);
		miRep.moverIzquierda();
	}
	
	//se mueve - en el eje y
	public void moverArriba() {
		actualizarMov = posicion.getY() - (alto/2);
		posicion.setY(actualizarMov);
		miRep.moverArriba();
	}
	
	//se mueve + en el eje y
	public void moverAbajo() {
		actualizarMov = posicion.getY() + (alto/2);
		posicion.setY(actualizarMov);
		miRep.moverAbajo();
	}
	

	public boolean perderVida() {
		vidas -= 1;
		return vidas == 0;
	}

	public void morir() {
		// SalaDeJuegos.getListaEliminar().add(this);
		// SalaDeJuegos.getJuego().finDeJuego();
	}

	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

}
