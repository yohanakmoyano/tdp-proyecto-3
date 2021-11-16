package entidades.movibles.jugadores;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.strategy.ControlStrategy;
import patrones.visitor_entidad.VisitorEntidad;
import patrones.visitor_entidad.VisitorJugador;

public class Jugador_456 extends Jugador {
	protected static Jugador_456 myInstance;
	protected Coordenada posRespawn;

	// TODO
	/**Dado que tira error al momento de crear los niveles, por ahora dejaré este constructor público.
	//Evitando así posibles errores al modificar esas lineas.
	//Una vez solucionado eso, pasar el constructor a privado.**/
	public Jugador_456(Coordenada c, int vel, int v, String rutaImg) {
		posRespawn = new Coordenada(c.getX(), c.getY());
		ultMovimiento = reposo;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		miVisitor = new VisitorJugador(this);
		velocidad = vel;
		vidas = v;
		posicion = c;
		ancho = 19;
		factorMovX = ancho/2;
		alto = 22;
		factorMovY = alto/2;
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
		ultMovimiento = ultMovDer;
		actualizarMov = posicion.getX() + (factorMovX);
		posicion.setX(actualizarMov);
		miRep.moverDerecha();
	}
	
	//se mueve - en el eje x
	public void moverIzquierda() {
		ultMovimiento = ultMovIzq;
		actualizarMov = posicion.getX() - (factorMovX);
		posicion.setX(actualizarMov);
		miRep.moverIzquierda();
	}
	
	//se mueve - en el eje y
	public void moverArriba() {
		ultMovimiento = ultMovUp;
		actualizarMov = posicion.getY() - (factorMovY);
		posicion.setY(actualizarMov);
		miRep.moverArriba();
	}
	
	//se mueve + en el eje y
	public void moverAbajo() {
		ultMovimiento = ultMovDown;
		actualizarMov = posicion.getY() + (factorMovY);
		posicion.setY(actualizarMov);
		miRep.moverAbajo();
	}

	public void morir() {
		//Ver como finalizar el juego.
		reUbicar();
	}
	
	public void reUbicar() {
		System.out.println("Pos anterior a muerte Jugador ("+posicion.getX() + ", " + posicion.getY()+")");
		miRep.eliminar();
		miRep.moverRep(posRespawn.getX(), posRespawn.getY());
		posicion.setX(posRespawn.getX());
		posicion.setY(posRespawn.getY());
		ultMovimiento = reposo;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		System.out.println("Pos posterior a muerte jugador ("+posicion.getX() + ", " + posicion.getY()+")");
	}
	
	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

	@Override
	public Coordenada nextPosMovDer() {
		return new Coordenada(posicion.getX() + (factorMovX), posicion.getY());
	}

	@Override
	public Coordenada nextPosMovIzq() {
		return new Coordenada(posicion.getX() - (factorMovX), posicion.getY());
	}

	@Override
	public Coordenada nextPosMovUp() {
		return new Coordenada(posicion.getX(), posicion.getY() - (factorMovY));
	}

	@Override
	public Coordenada nextPosMovDown() {
		return new Coordenada(posicion.getX(), posicion.getY() + (factorMovY));
	}

}
