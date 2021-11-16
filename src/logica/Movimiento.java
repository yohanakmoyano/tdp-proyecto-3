package logica;

import entidades.Entidad;
import entidades.movibles.enemigos.Enemigo;

public class Movimiento extends Thread {
	protected SalaDeJuegos sala;
	protected boolean deboMover;
	
	public Movimiento(SalaDeJuegos sj) {
		sala = sj;
		deboMover = true;
	}
	
	public void run() {		
		while(deboMover) {
			try {
				Thread.sleep(40); // 40 anda bien
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			moverEnemigos();
		}
	}
	
	public boolean getDeboMover(){ return deboMover ;}
	public void setDeboMover(boolean deboMover){ this.deboMover = deboMover ;}
	
	protected void moverEnemigos() {
		for(Entidad e : sala.getListaEnemigos()) {
			moverEnemigoDer((Enemigo)e);
			moverEnemigoDer((Enemigo)e);
			moverEnemigoDer((Enemigo)e);
			moverEnemigoDer((Enemigo)e);
			moverEnemigoIzq((Enemigo)e);
			moverEnemigoUp((Enemigo)e);
			moverEnemigoUp((Enemigo)e);
			moverEnemigoUp((Enemigo)e);
			moverEnemigoDown((Enemigo)e);
		}
	}
	
	protected void moverEnemigoDer(Enemigo e) {
		if(sala.autorizarMovDerecha(e)) {
			e.moverDerecha();
			sala.actualizarZonasEntidad(e);
			sala.detectarColisionesJugador(e);
		} 
	} 
	
	protected void moverEnemigoIzq(Enemigo e) {
		if(sala.autorizarMovIzquierda(e)) {
			e.moverIzquierda();
			sala.actualizarZonasEntidad(e);
			sala.detectarColisionesJugador(e);
		}
	} 
	
	protected void moverEnemigoUp(Enemigo e) {
		if(sala.autorizarMovArriba(e)) {
			e.moverArriba();
			sala.actualizarZonasEntidad(e);
			sala.detectarColisionesJugador(e);
		}
	} 
	
	protected void moverEnemigoDown(Enemigo e) {
		if(sala.autorizarMovAbajo(e)) {
			e.moverAbajo();
			sala.actualizarZonasEntidad(e);
			sala.detectarColisionesJugador(e);
		}
	} 
	
}
