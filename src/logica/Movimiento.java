package logica;

import java.util.Random;
import entidades.Entidad;
import entidades.movibles.enemigos.Enemigo;

public class Movimiento extends Thread {
	protected SalaDeJuegos sala;
	protected Juego miJuego;
	protected boolean deboMover;
	protected Random ran;

	public Movimiento(SalaDeJuegos sj, Juego miJ) {
		miJuego = miJ;
		sala = sj;
		deboMover = true;
		ran = new Random();
	}


	public void run() {
		while (deboMover) {
			try {
				Thread.sleep(50);
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

	protected void moverEnemigos() {
		
		for (Entidad e : sala.getListaEnemigos()) {
			int mov = ran.nextInt(4);
			miJuego.operar(mov, (Enemigo)e);
		}
	
	}

}
