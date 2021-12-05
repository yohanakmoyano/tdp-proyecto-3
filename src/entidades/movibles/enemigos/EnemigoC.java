package entidades.movibles.enemigos;

import java.util.Random;

import entidades.movibles.EntidadMovible;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.strategy_enem.Asesino;
import patrones.visitor_entidad.VisitorEnemigo;
import patrones.visitor_entidad.VisitorEntidad;

public class EnemigoC extends Enemigo {
	// JDC: Triangulo, AU: Pink , PC: Pinky

	public EnemigoC(Coordenada c, String rutaImg) {
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

	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

	public Coordenada nextPosMovDer() {
		return new Coordenada(posicion.getX() + (factorMovX*velocidad), posicion.getY());
	}

	public Coordenada nextPosMovIzq() {
		return new Coordenada(posicion.getX() - (factorMovX*velocidad), posicion.getY());
	}

	public Coordenada nextPosMovUp() {
		return new Coordenada(posicion.getX(), posicion.getY() - (factorMovY*velocidad));
	}

	public Coordenada nextPosMovDown() {
		return new Coordenada(posicion.getX(), posicion.getY() + (factorMovY*velocidad));
	}

	public int mover() {
		int ultMov = elJugador.getUltMovimiento();
		int xJug = elJugador.getPosicion().getX();
		int yJug = elJugador.getPosicion().getY();
		switch(ultMov) {
		case(EntidadMovible.MOV_DER): {
			xJug += (2 + factorMovX);
			break;
		} 
		case(EntidadMovible.MOV_IZQ): {
			xJug -= (2 + factorMovX);
			break;
		}
		case(EntidadMovible.MOV_UP): {
			yJug -= (4 + factorMovY);
			break;
		} 
		case(EntidadMovible.MOV_DOWN): {
			yJug += (4 + factorMovY);
			break;
		}
		}
		if((xJug > 0) && (yJug > 0)) {

			Random r = new Random();
			int eje = r.nextInt(2);
			
			if ( miSalon.estaDentro(this)) {
				   movEnCola = getMovPosible(MOV_UP);
			}	
			else {
				if(eje == ejeX) { //Mover sobre X
					if((posicion.getX() - xJug) < 0) { //moverDerecha
						movEnCola = getMovPosible(MOV_DER);
					} else { //moverIzquierda
						movEnCola = getMovPosible(MOV_IZQ);
					}
				} else { //MoverSobreY
					if((posicion.getY() - yJug) < 0) { //MoverAbajo
						movEnCola = getMovPosible(MOV_DOWN);
					} else {//MoverArriba
						movEnCola = getMovPosible(MOV_UP);
					}
				}
			}
			miEstrategia.mover(movEnCola);
		}
		//Faltan agregar condiciones para que no se quede moviendo siempre en una misma dirección.
		return movEnCola;
	}
}
