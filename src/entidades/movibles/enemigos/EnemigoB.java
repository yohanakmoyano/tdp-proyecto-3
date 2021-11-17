package entidades.movibles.enemigos;

import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public abstract class EnemigoB extends Enemigo {
	@Override
	public void moverArriba() {
		ultMovimiento = ultMovUp;
		actualizarMov = posicion.getY() - (factorMovY);
		posicion.setY(actualizarMov);
		miRep.moverArriba();
	}

	@Override
	public void moverAbajo() {
		ultMovimiento = ultMovDown;
		actualizarMov = posicion.getY() + (factorMovY);
		posicion.setY(actualizarMov);
		miRep.moverAbajo();
	}

	@Override
	public void moverIzquierda() {
		ultMovimiento = ultMovIzq;
		actualizarMov = posicion.getX() - (factorMovX);
		posicion.setX(actualizarMov);
		miRep.moverIzquierda();
	}

	@Override
	public void moverDerecha() {
		ultMovimiento = ultMovDer;
		actualizarMov = posicion.getX() + (factorMovX);
		posicion.setX(actualizarMov);
		miRep.moverDerecha();
	}
	
	@Override
	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

	@Override
	public void morir() {
		System.out.println("Pos anterior a muerte Boss ("+posicion.getX() + ", " + posicion.getY()+")");
		miRep.moverRep(miSalon.getRespawnPoint().getX(), miSalon.getRespawnPoint().getY());
		posicion.setX(miSalon.getRespawnPoint().getX());
		posicion.setY(miSalon.getRespawnPoint().getY());
		ultMovimiento = reposo;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		System.out.println("Pos posterior a muerte Boss ("+posicion.getX() + ", " + posicion.getY()+")");
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
