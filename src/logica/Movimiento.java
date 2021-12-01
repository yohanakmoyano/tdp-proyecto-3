package logica;

import java.util.Random;

import entidades.Entidad;
import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;

public class Movimiento extends Thread {
	protected SalaDeJuegos sala;
	protected boolean deboMover;
	protected Random ran;
	protected Jugador jug;

	public Movimiento(SalaDeJuegos sj, Jugador jug) {
		sala = sj;
		deboMover = true;
		ran = new Random();
		this.jug = jug;
	}


	public void run() {
		while (deboMover) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			moverEnemigos();
		}
	}

	public boolean getDeboMover() {
		return deboMover;
	}

	public void setDeboMover(boolean deboMover) {
		this.deboMover = deboMover;
	}

	//Movimiento aleatorio sin sentido.
	protected void moverEnemigos() {
		for (Entidad e : sala.getListaEnemigos()) {
			int mov = ran.nextInt(4);
			moverMientrasPueda((Enemigo) e, mov);
		}
	}
	
	//aproximaci�n a movimiento solicitado
	/*protected void moverEnemigos() {
		for(Entidad e : sala.getListaEnemigos()) {
			int movEje = ran.nextInt(2);
			//int movEje = ran.nextInt(4);
			//moverMientrasPueda((Enemigo)e, movEje);
			((Enemigo)e).mover(jug.getPosicion(), movEje, this);
		}
	}*/
	protected synchronized void moverMientrasPueda(Enemigo e, int direccion) {
		switch (direccion) {
			case (0): {
				moverEnemigoDer(e);
				break;
			}
			case (1): {
				moverEnemigoIzq(e);
				break;
			}
			case (2): {
				moverEnemigoUp(e);
				break;
			}
			case (3): {
				moverEnemigoDown(e);
				break;
			}
		}
	}

	/**
	 * Considerando que quiero ir de p1 a p2, en direccion horizontal hacia el este manteniendo fija la ordenada, devuelve el punto m�s lejano al
	 * que puede llegar sin colisionar con una pared.
	 * @param p1 Coordenada origen.
	 * @param p2 Coordenada destino.
	 * @return pout coordenada llegada.
	 */
	protected Coordenada topeMovDer(Coordenada p1, Coordenada p2) {
		Coordenada pout = new Coordenada(p1.getX(), p1.getY());
		boolean colisiona = false;
		while((pout.getX()<sala.getBase()) && (pout.getX() > 0) && !colisiona && (pout.getX() != p2.getX())) {
			colisiona = sala.posColisiona(pout);
			if(!colisiona) 
				pout.setX(pout.getX()+1);
		}
		return pout;
	}
	
	/**
	 * Considerando que quiero ir de p1 a p2, en direccion horizontal hacia el oeste manteniendo fija la ordenada, devuelve el punto m�s lejano al
	 * que puede llegar sin colisionar con una pared.
	 * @param p1 Coordenada origen.
	 * @param p2 Coordenada destino.
	 * @return pout coordenada llegada.
	 */
	protected Coordenada topeMovIzq(Coordenada p1, Coordenada p2) {
		Coordenada pout = new Coordenada(p1.getX(), p1.getY());
		boolean colisiona = false;
		while((pout.getX()<sala.getBase()) && (pout.getX() > 0) && !colisiona && (pout.getX() != p2.getX())) {
			colisiona = sala.posColisiona(pout);
			if(!colisiona) 
				pout.setX(pout.getX()-1);
		}
		return pout;
	}
	
	/**
	 * Considerando que quiero ir de p1 a p2, en direccion vertical hacia el norte manteniendo fija la absisa, devuelve el punto m�s lejano al
	 * que puede llegar sin colisionar con una pared.
	 * @param p1 Coordenada origen.
	 * @param p2 Coordenada destino.
	 * @return pout coordenada llegada.
	 */
	protected Coordenada topeMovUp(Coordenada p1, Coordenada p2) {
		Coordenada pout = new Coordenada(p1.getX(), p1.getY());
		boolean colisiona = false;
		while((pout.getY()<sala.getAltura()) && (pout.getY() > 0) && !colisiona && (pout.getY() != p2.getY())) {
			colisiona = sala.posColisiona(pout);
			if(!colisiona) 
				pout.setY(pout.getY()-1);
		}
		return pout;
	}
	
	/**
	 * Considerando que quiero ir de p1 a p2, en direccion vertical hacia el sur manteniendo fija la absisa, devuelve el punto m�s lejano al
	 * que puede llegar sin colisionar con una pared.
	 * @param p1 Coordenada origen.
	 * @param p2 Coordenada destino.
	 * @return pout coordenada llegada.
	 */
	protected Coordenada topeMovDown(Coordenada p1, Coordenada p2) {
		Coordenada pout = new Coordenada(p1.getX(), p1.getY());
		boolean colisiona = false;
		while((pout.getY() < sala.getAltura()) && (pout.getY() > 0) && !colisiona && (pout.getY() != p2.getY())) {
			colisiona = sala.posColisiona(pout);
			if(!colisiona) 
				pout.setY(pout.getY()+1);
		}
		return pout;
	}
	
	/**
	 * Se encarga de mover a e en direcci�n este u oeste seg�n corresponda todo lo que pueda hasta que se encuentre una pared.
	 * @param x1 coordenada X origen.
	 * @param x2 coordenada X destino.
	 * @param e Enemigo que quiero mover.
	 */
	public void moverEnX(int x1, int x2, Enemigo e) {
		if(x1 != x2) {
			if((x1 - x2) < 0) {//MoverDerecha
				Coordenada newPosDer = topeMovDer(e.getPosicion(), jug.getPosicion());
				while(e.getPosicion().getX() <= newPosDer.getX()) {
					moverEnemigoDer(e);
				}
			} else { //MoverIzquierda
				Coordenada newPosIzq = topeMovIzq(e.getPosicion(), jug.getPosicion());
				while(e.getPosicion().getX() >= newPosIzq.getX()) {
					moverEnemigoIzq(e);
				}
			}
		}
	}
	
	/**
	 * Se encarga de mover a e en direcci�n norte u sur seg�n corresponda todo lo que pueda hasta que se encuentre una pared.
	 * @param y1 coordenada Y origen.
	 * @param y2 coordenada Y destino.
	 * @param e Enemigo que quiero mover.
	 */
	public void moverEnY(int y1, int y2, Enemigo e) {
		if(y1 != y2) {
			if((y1 - y2) > 0) {//MoverUp
				Coordenada newPosUp = topeMovUp(e.getPosicion(), jug.getPosicion());
				while(e.getPosicion().getY() >= newPosUp.getY()) {
					moverEnemigoUp(e);
				}
			} else {//MoverDown
				Coordenada newPosDown = topeMovDown(e.getPosicion(), jug.getPosicion());
				while(e.getPosicion().getY() <= newPosDown.getY()) {
					moverEnemigoDown(e);
				}
			}
		}
	}
	
	protected void moverEnemigoDer(Enemigo e) {
		if (sala.autorizarMovDerecha(e)) {
			Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
			e.moverDerecha();
			sala.actualizarZonasEntidad(posAnt, e);
			sala.detectarColisionesEntidad(posAnt, e);
		}
	}

	protected void moverEnemigoIzq(Enemigo e) {
		if (sala.autorizarMovIzquierda(e)) {
			Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
			e.moverIzquierda();
			sala.actualizarZonasEntidad(posAnt, e);
			sala.detectarColisionesEntidad(posAnt, e);
		}
	}

	protected void moverEnemigoUp(Enemigo e) {
		if (sala.autorizarMovArriba(e)) {
			Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
			e.moverArriba();
			sala.actualizarZonasEntidad(posAnt, e);
			sala.detectarColisionesEntidad(posAnt, e);
		}
	}

	protected void moverEnemigoDown(Enemigo e) {
		if (sala.autorizarMovAbajo(e)) {
			Coordenada posAnt = new Coordenada(e.getPosicion().getX(), e.getPosicion().getY());
			e.moverAbajo();
			sala.actualizarZonasEntidad(posAnt, e);
			sala.detectarColisionesEntidad(posAnt, e);
		}
	}

}
