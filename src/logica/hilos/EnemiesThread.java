package logica.hilos;

import java.util.Random;

import entidades.movibles.EntidadMovible;
import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import logica.Coordenada;

public class EnemiesThread extends EntidadMovibleThread {
	protected boolean deboMover;
	protected Random ran;
	protected Jugador jug;
	//protected List<Enemigo> enemies;
	
	@Override
	public void preparar() {
		// TODO Auto-generated method stub
		/**enemies = new HashSet<Enemigo>();
		for(Entidad e : miSala.getListaEnemigos()) {
			enemies.add((Enemigo)e);
		}*/
		ran = new Random();
		deboMover = true;
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		this.start();
	}

	public boolean getDeboMover() {
		return deboMover;
	}

	public void setDeboMover(boolean deboMover) {
		this.deboMover = deboMover;
	}

	public void setJugador(Jugador jug) {
		this.jug = jug;
	}
	
	public void run() {
		while (deboMover) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Debo mover");
			//moverEnemigos();
		}
	}
	
	protected void moverEnemigos() {
		Coordenada posJug = new Coordenada(jug.getPosicion().getX(), jug.getPosicion().getY());
		System.out.println("Enemigos");
		for(EntidadMovible e : entidadesMovibles) {
			int movEje = ran.nextInt(2);
			((Enemigo)e).mover(posJug, movEje, this);
			System.out.println("Enemigos");
		}
	}
	
	/**
	 * Considerando que quiero ir de p1 a p2, en direccion horizontal hacia el este manteniendo fija la ordenada, devuelve el punto más lejano al
	 * que puede llegar sin colisionar con una pared.
	 * @param p1 Coordenada origen.
	 * @param p2 Coordenada destino.
	 * @return pout coordenada llegada.
	 */
	protected Coordenada topeMovDer(Coordenada p1, Coordenada p2) {
		Coordenada pout = new Coordenada(p1.getX(), p1.getY());
		boolean colisiona = false;
		while((pout.getX()<miSala.getBase()) && (pout.getX() > 0) && !colisiona && (pout.getX() != p2.getX())) {
			colisiona = miSala.posColisiona(pout);
			if(!colisiona) 
				pout.setX(pout.getX()+1);
		}
		System.out.println("Origen "+p1.getX()+" - "+p1.getY());
		System.out.println("Destino "+p2.getX()+" - "+p2.getY());
		System.out.println("Tope actual "+pout.getX()+" - "+pout.getY());
		return pout;
	}
	
	/**
	 * Considerando que quiero ir de p1 a p2, en direccion horizontal hacia el oeste manteniendo fija la ordenada, devuelve el punto más lejano al
	 * que puede llegar sin colisionar con una pared.
	 * @param p1 Coordenada origen.
	 * @param p2 Coordenada destino.
	 * @return pout coordenada llegada.
	 */
	protected Coordenada topeMovIzq(Coordenada p1, Coordenada p2) {
		Coordenada pout = new Coordenada(p1.getX(), p1.getY());
		boolean colisiona = false;
		while((pout.getX()<miSala.getBase()) && (pout.getX() > 0) && !colisiona && (pout.getX() != p2.getX())) {
			colisiona = miSala.posColisiona(pout);
			if(!colisiona) 
				pout.setX(pout.getX()-1);
		}
		System.out.println("Origen "+p1.getX()+" - "+p1.getY());
		System.out.println("Destino "+p2.getX()+" - "+p2.getY());
		System.out.println("Tope actual "+pout.getX()+" - "+pout.getY());
		return pout;
	}
	
	/**
	 * Considerando que quiero ir de p1 a p2, en direccion vertical hacia el norte manteniendo fija la absisa, devuelve el punto más lejano al
	 * que puede llegar sin colisionar con una pared.
	 * @param p1 Coordenada origen.
	 * @param p2 Coordenada destino.
	 * @return pout coordenada llegada.
	 */
	protected Coordenada topeMovUp(Coordenada p1, Coordenada p2) {
		Coordenada pout = new Coordenada(p1.getX(), p1.getY());
		boolean colisiona = false;
		while((pout.getY()<miSala.getAltura()) && (pout.getY() > 0) && !colisiona && (pout.getY() != p2.getY())) {
			colisiona = miSala.posColisiona(pout);
			if(!colisiona) 
				pout.setY(pout.getY()-1);
		}
		System.out.println("Origen "+p1.getX()+" - "+p1.getY());
		System.out.println("Destino "+p2.getX()+" - "+p2.getY());
		System.out.println("Tope actual "+pout.getX()+" - "+pout.getY());
		return pout;
	}
	
	/**
	 * Considerando que quiero ir de p1 a p2, en direccion vertical hacia el sur manteniendo fija la absisa, devuelve el punto más lejano al
	 * que puede llegar sin colisionar con una pared.
	 * @param p1 Coordenada origen.
	 * @param p2 Coordenada destino.
	 * @return pout coordenada llegada.
	 */
	protected Coordenada topeMovDown(Coordenada p1, Coordenada p2) {
		Coordenada pout = new Coordenada(p1.getX(), p1.getY());
		boolean colisiona = false;
		while((pout.getY() < miSala.getAltura()) && (pout.getY() > 0) && !colisiona && (pout.getY() != p2.getY())) {
			colisiona = miSala.posColisiona(pout);
			if(!colisiona) 
				pout.setY(pout.getY()+1);
		}
		System.out.println("Tope actual "+pout.getX()+" - "+pout.getY());
		return pout;
	}
	
	/**
	 * Se encarga de mover a e en dirección este u oeste según corresponda todo lo que pueda hasta que se encuentre una pared.
	 * @param x1 coordenada X origen.
	 * @param x2 coordenada X destino.
	 * @param e Enemigo que quiero mover.
	 */
	public void moverEnX(int x1, int x2, Enemigo e) {
		if(x1 != x2) {
			if((x1 - x2) < 0) {//MoverDerecha
				Coordenada newPosDer = topeMovDer(e.getPosicion(), jug.getPosicion());
				while(e.getPosicion().getX() <= newPosDer.getX()) {
					moverDerecha(e);
				}
				System.out.println("Destino actual "+newPosDer.getX()+" - "+newPosDer.getY());
			} else { //MoverIzquierda
				Coordenada newPosIzq = topeMovIzq(e.getPosicion(), jug.getPosicion());
				while(e.getPosicion().getX() >= newPosIzq.getX()) {
					moverIzquierda(e);
				}
				System.out.println("Destino actual "+newPosIzq.getX()+" - "+newPosIzq.getY());
			}
		}
	}
	
	/**
	 * Se encarga de mover a e en dirección norte u sur según corresponda todo lo que pueda hasta que se encuentre una pared.
	 * @param y1 coordenada Y origen.
	 * @param y2 coordenada Y destino.
	 * @param e Enemigo que quiero mover.
	 */
	public void moverEnY(int y1, int y2, Enemigo e) {
		if(y1 != y2) {
			if((y1 - y2) > 0) {//MoverUp
				Coordenada newPosUp = topeMovUp(e.getPosicion(), jug.getPosicion());
				while(e.getPosicion().getY() >= newPosUp.getY()) {
					moverArriba(e);
				}
				System.out.println("Destino actual "+newPosUp.getX()+" - "+newPosUp.getY());
			} else {//MoverDown
				Coordenada newPosDown = topeMovDown(e.getPosicion(), jug.getPosicion());
				while(e.getPosicion().getY() <= newPosDown.getY()) {
					moverAbajo(e);
				}
				System.out.println("Destino actual "+newPosDown.getX()+" - "+newPosDown.getY());
			}
		}
	}
	
}
