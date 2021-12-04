package entidades.movibles;

import entidades.Entidad;
import logica.Coordenada;

public abstract class EntidadMovible extends Entidad {
	protected int velocidad;
	protected int vidas;
	protected int actualizarMov;
	protected boolean puedoMovermeIzq;
	protected boolean puedoMovermeDer;
	protected boolean puedoMovermeUp;
	protected boolean puedoMovermeDown;
	
	protected static int ultMovimiento;
	protected static int movEnCola;

	public static final int ejeX = 0;
	public static final int ejeY = 1;	
	
	public static final int REPOSO = 0;
	public static final int MOV_IZQ = 1;
	public static final int MOV_DER = 2;
	public static final int MOV_UP = 3;
	public static final int MOV_DOWN = 4;
	
	protected int factorMovX;
	protected int factorMovY;

	public int getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(int vel) {
		velocidad = vel;
	}
	
	//Le dice a la entidad hacia donde desea moverse actualmente.
	public void setMovEnCola(int mov) {
		movEnCola = mov;
	}
	
	public int getUltMovimiento() {
		return ultMovimiento;
	}
	
	public boolean puedoMovermeIzq() {
		return puedoMovermeIzq;
	}
	
	public void setPuedoMovermeIzq(boolean mov) {
		puedoMovermeIzq = mov;
	}

	public boolean puedoMovermeDer() {
		return puedoMovermeDer;
	}
	
	public void setPuedoMovermeDer(boolean mov) {
		puedoMovermeDer = mov;
	}

	public boolean puedoMovermeUp() {
		return puedoMovermeUp;
	}
	
	public void setPuedoMovermeUp(boolean mov) {
		puedoMovermeUp = mov;
	}

	public boolean puedoMovermeDown() {
		return puedoMovermeDown;
	}
	
	public void setPuedoMovermeDown(boolean mov) {
		puedoMovermeDown = mov;
	}
	
	public int getVidas() {
		return vidas;
	}
	
	public void setVidas(int v) {
		vidas=v;
	}
	
	public void comeBack() {
		switch(ultMovimiento) {
		case(MOV_DER): {
			posicion.comeBackX();
			ultMovimiento = MOV_IZQ;
			//puedoMovermeDer = false; Comentado hasta resolver como actualizar luego de bloquearlo correctamente.
			break;
		}
		case(MOV_IZQ): {
			posicion.comeBackX();
			ultMovimiento = MOV_DER;
			//puedoMovermeIzq = false;
			break;
		}
		case(MOV_UP): {
			posicion.comeBackY();
			ultMovimiento = MOV_DOWN;
			//puedoMovermeUp = false;
			break;
		}
		case(MOV_DOWN): {
			posicion.comeBackY();
			ultMovimiento = MOV_UP;
			//puedoMovermeDown = false;
			break;
		}
		}
		//ultMovimiento = REPOSO;
		miRep.moverRep(posicion.getX(), posicion.getY());
	}
	
	/**
	 * Resuelve el movimiento de la entidad.
	 * @return un entero que corresponde con el movimiento realizado.
	 */
	public abstract int mover();
	
	public abstract Coordenada nextPosMovDer();
	
	public abstract Coordenada nextPosMovIzq();
	
	public abstract Coordenada nextPosMovUp();
	
	public abstract Coordenada nextPosMovDown();
	
	public void bloquearMovimiento(int mov) {
		switch(mov) {
		case(MOV_DER): {
			puedoMovermeDer = false;
			break;
		}
		case(MOV_IZQ): {
			puedoMovermeIzq = false;
			break;
		}
		case(MOV_UP): {
			puedoMovermeUp = false;
			break;
		}
		case(MOV_DOWN): {
			puedoMovermeDown = false;
			break;
		}
		}
	}
	
	public void moverDerecha() {
		puedoMovermeIzq = true;
		ultMovimiento = MOV_DER;
		movEnCola = MOV_DER;
		actualizarMov = posicion.getX() + (factorMovX*velocidad);
		posicion.setX(actualizarMov);
		miRep.moverDerecha(factorMovX*velocidad);
	}

	public void moverIzquierda() {
		puedoMovermeDer = true;
		ultMovimiento = MOV_IZQ;
		movEnCola = MOV_IZQ;
		actualizarMov = posicion.getX() - (factorMovX*velocidad);
		posicion.setX(actualizarMov);
		miRep.moverIzquierda(factorMovX*velocidad);
	}

	public void moverArriba() {
		puedoMovermeDown = true;
		ultMovimiento = MOV_UP;
		movEnCola = MOV_UP;
		actualizarMov = posicion.getY() - (factorMovY*velocidad);
		posicion.setY(actualizarMov);
		miRep.moverArriba(factorMovY*velocidad);
	}

	public void moverAbajo() {
		puedoMovermeUp = true;
		ultMovimiento = MOV_DOWN;
		movEnCola = MOV_DOWN;
		actualizarMov = posicion.getY() + (factorMovY*velocidad);
		posicion.setY(actualizarMov);
		miRep.moverAbajo(factorMovY*velocidad);
	}

	public void perderVida() {
		vidas--;
	}
	
	public abstract void morir();
}
