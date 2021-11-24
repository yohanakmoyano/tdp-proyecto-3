package entidades.movibles.enemigos;

import entidades.movibles.jugadores.Jugador;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import logica.Movimiento;
import patrones.visitor_entidad.VisitorEnemigo;
import patrones.visitor_entidad.VisitorEntidad;

public class EnemigoC extends Enemigo {
	// JDC: Triangulo, AU: Pink , PC: Pinky

	public EnemigoC(Coordenada c, String rutaImg) {
		alive = true;
		caminable = true;
		ultMovimiento = reposo;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		miVisitor = new VisitorEnemigo(this);
		posicion = c;
		ancho = 20;
		factorMovX = ancho / 4;
		alto = 20;
		factorMovY = alto / 4;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}

	@Override
	public void moverArriba() {
		puedoMovermeDown = true;
		ultMovimiento = ultMovUp;
		actualizarMov = posicion.getY() - (factorMovY);
		posicion.setY(actualizarMov);
		miRep.moverArriba(factorMovY);
	}

	@Override
	public void moverAbajo() {
		puedoMovermeUp = true;
		ultMovimiento = ultMovDown;
		actualizarMov = posicion.getY() + (factorMovY);
		posicion.setY(actualizarMov);
		miRep.moverAbajo(factorMovY);
	}

	@Override
	public void moverIzquierda() {
		puedoMovermeDer = true;
		ultMovimiento = ultMovIzq;
		actualizarMov = posicion.getX() - (factorMovX);
		posicion.setX(actualizarMov);
		miRep.moverIzquierda(factorMovX);
	}

	@Override
	public void moverDerecha() {
		puedoMovermeIzq = true;
		ultMovimiento = ultMovDer;
		actualizarMov = posicion.getX() + (factorMovX);
		posicion.setX(actualizarMov);
		miRep.moverDerecha(factorMovX);
	}

	@Override
	public void accept(VisitorEntidad v) {
		v.visit(this);

	}

	@Override
	public void morir() {
		this.isDead();
		miRep.moverRep(miSalon.getRespawnPoint().getX(), miSalon.getRespawnPoint().getY());
		posicion.setX(miSalon.getRespawnPoint().getX());
		posicion.setY(miSalon.getRespawnPoint().getY());
		ultMovimiento = reposo;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		this.revive();
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

	public void mover(Coordenada posDest, int eje, Movimiento mov) {
		int ultMov = Jugador.ultMovimiento;
		Coordenada destino = new Coordenada(posDest.getX(), posDest.getY());
		if(eje == ejeX) {
			switch(ultMov) {
				case(Jugador.ultMovDer): {
					destino.setX(destino.getX() + 2);
					break;
				} 
				case(Jugador.ultMovIzq): {
					destino.setX(destino.getX() - 2);
					break;
				}
			}
			moverEnX(this.posicion.getX(), posDest.getX(), mov.topeMovDer(posicion, posDest).getX(), mov.topeMovIzq(posicion, posDest).getX(), mov);
		} else {
			if(eje == ejeY) {
				switch(ultMov) {
					case(Jugador.ultMovUp): {
						destino.setX(destino.getX() - 4);
						break;
					} 
					case(Jugador.ultMovDown): {
						destino.setX(destino.getX() + 4);
						break;
					}
				}
				moverEnY(this.posicion.getY(), posDest.getY(), mov.topeMovUp(posicion, posDest).getY(), mov.topeMovDown(posicion, posDest).getY(), mov);
			}
		}
	}
}
