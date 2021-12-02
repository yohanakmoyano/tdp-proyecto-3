package entidades.movibles.enemigos;

import entidades.movibles.jugadores.Jugador;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import logica.hilos.EnemiesThread;
import patrones.visitor_entidad.VisitorEnemigo;
import patrones.visitor_entidad.VisitorEntidad;

public class EnemigoC extends Enemigo {
	// JDC: Triangulo, AU: Pink , PC: Pinky

	public EnemigoC(Coordenada c, String rutaImg) {
		velocidad = 1;
		alive = true;
		caminable = true;
		ultMovimiento = REPOSO;
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
	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

	@Override
	public void morir() {
		this.isDead();
		miRep.moverRep(miSalon.getRespawnPoint().getX(), miSalon.getRespawnPoint().getY());
		posicion.setX(miSalon.getRespawnPoint().getX());
		posicion.setY(miSalon.getRespawnPoint().getY());
		ultMovimiento = REPOSO;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		this.revive();
	}

	@Override
	public Coordenada nextPosMovDer() {
		return new Coordenada(posicion.getX() + (factorMovX*velocidad), posicion.getY());
	}

	@Override
	public Coordenada nextPosMovIzq() {
		return new Coordenada(posicion.getX() - (factorMovX*velocidad), posicion.getY());
	}

	@Override
	public Coordenada nextPosMovUp() {
		return new Coordenada(posicion.getX(), posicion.getY() - (factorMovY*velocidad));
	}

	@Override
	public Coordenada nextPosMovDown() {
		return new Coordenada(posicion.getX(), posicion.getY() + (factorMovY*velocidad));
	}

	public void mover(Coordenada posDest, int eje, EnemiesThread mov) {
		int ultMov = Jugador.ultMovimiento;
		Coordenada destino = new Coordenada(posDest.getX(), posDest.getY());
		if(eje == ejeX) {
			switch(ultMov) {
				case(Jugador.ULT_MOV_DER): {
					destino.setX(destino.getX() + 2);
					break;
				} 
				case(Jugador.ULT_MOV_IZQ): {
					destino.setX(destino.getX() - 2);
					break;
				}
			}
			mov.moverEnX(this.posicion.getX(), posDest.getX(), this);
			//moverEnX(this.posicion.getX(), posDest.getX(), mov.topeMovDer(posicion, posDest).getX(), mov.topeMovIzq(posicion, posDest).getX(), mov);
		} else {
			if(eje == ejeY) {
				switch(ultMov) {
					case(Jugador.ULT_MOV_UP): {
						destino.setX(destino.getX() - 4);
						break;
					} 
					case(Jugador.ULT_MOV_DOWN): {
						destino.setX(destino.getX() + 4);
						break;
					}
				}
				mov.moverEnY(this.posicion.getY(), posDest.getY(), this);
				//moverEnY(this.posicion.getY(), posDest.getY(), mov.topeMovUp(posicion, posDest).getY(), mov.topeMovDown(posicion, posDest).getY(), mov);
			}
		}
	}
}
