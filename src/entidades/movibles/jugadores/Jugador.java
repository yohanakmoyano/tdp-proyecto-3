package entidades.movibles.jugadores;

import entidades.movibles.EntidadMovible;
import logica.Coordenada;
import patrones.strategy.ControlStrategy;
import patrones.visitor_entidad.VisitorEntidad;

public abstract class Jugador extends EntidadMovible {
	protected ControlStrategy controlStr;
	protected Coordenada posRespawn;
	public ControlStrategy getEstrategia() {
		return controlStr;
	}
	
	/**
	 * Por el momento hace una especie de switch entre las dos estrategias existentes.
	 * Ver como hacer para que esto no dependa de que solo existen dos estrategias.
	 */
	public void cambiarEstrategia() {
		
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
		//System.out.println("Pos anterior a muerte Jugador ("+posicion.getX() + ", " + posicion.getY()+")");
		miRep.eliminar();
		miRep.moverRep(posRespawn.getX(), posRespawn.getY());
		posicion.setX(posRespawn.getX());
		posicion.setY(posRespawn.getY());
		ultMovimiento = reposo;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		//System.out.println("Pos posterior a muerte jugador ("+posicion.getX() + ", " + posicion.getY()+")");
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
