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
	public static final int REPOSO = 0;
	public static final int ULT_MOV_IZQ = 1;
	public static final int ULT_MOV_DER = 2;
	public static final int ULT_MOV_UP = 3;
	public static final int ULT_MOV_DOWN = 4;
	protected int factorMovX;
	protected int factorMovY;

	public int getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(int vel) {
		velocidad = vel;
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
		case(ULT_MOV_DER): {
			posicion.comeBackX();
			//puedoMovermeDer = false; Comentado hasta resolver como actualizar luego de bloquearlo correctamente.
			break;
		}
		case(ULT_MOV_IZQ): {
			posicion.comeBackX();
			//puedoMovermeIzq = false;
			break;
		}
		case(ULT_MOV_UP): {
			posicion.comeBackY();
			//puedoMovermeUp = false;
			break;
		}
		case(ULT_MOV_DOWN): {
			posicion.comeBackY();
			//puedoMovermeDown = false;
			break;
		}
		}
		ultMovimiento = REPOSO;
		miRep.moverRep(posicion.getX(), posicion.getY());
	}
	
	public abstract Coordenada nextPosMovDer();
	
	public abstract Coordenada nextPosMovIzq();
	
	public abstract Coordenada nextPosMovUp();
	
	public abstract Coordenada nextPosMovDown();
	
	public abstract void moverDerecha();
	
	public abstract void moverIzquierda();

	public abstract void moverArriba();
	
	public abstract void moverAbajo();
	
	public void perderVida() {
		vidas--;
	}
	
	public abstract void morir();
}
