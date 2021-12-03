package entidades.movibles.enemigos;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.strategy_enem.Asesino;
import patrones.visitor_entidad.VisitorEnemigo;
import patrones.visitor_entidad.VisitorEntidad;

public class EnemigoA extends Enemigo {
//AU: black , JDC: Boss , PC: Blinky

	public EnemigoA(Coordenada c, String rutaImg) {
		miEstrategia = new Asesino();
		miEstrategia.setEnemigo(this);
		velocidad = 1;
		alive = true;
		caminable = true;
		movEnCola = REPOSO;
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
	
	@Override
	public int mover() {
		int xJug = elJugador.getPosicion().getX();
		int yJug = elJugador.getPosicion().getY();
		int distX = posicion.distanciaX(xJug);
		int distY = posicion.distanciaY(yJug);
		if(distX <= distY) { //Mover sobre X
			if((posicion.getX() - xJug) < 0) { //moverDerecha
				movEnCola = MOV_DER;
			} else { //moverIzquierda
				movEnCola = MOV_IZQ;
			}
		} else { //MoverSobreY
			if((posicion.getY() - yJug) < 0) { //MoverAbajo
				movEnCola = MOV_DOWN;
			} else {//MoverArriba
				movEnCola = MOV_UP;
			}
		}
		miEstrategia.mover(movEnCola);
		//Faltan agregar condiciones para que no se quede moviendo siempre en una misma dirección.
		return movEnCola;
	}
}
