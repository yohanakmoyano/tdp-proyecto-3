package logica.hilos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entidades.movibles.EntidadMovible;

public class JugadorThread extends EntidadMovibleThread implements KeyListener {
	protected static final int moverIzquierda = 1;
	protected static final int moverDerecha = 2;
	protected static final int moverAbajo = 3;
	protected static final int moverArriba = 4;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT: {
				operar(JugadorThread.moverIzquierda);
				break;
			}
			case KeyEvent.VK_RIGHT: {
				operar(JugadorThread.moverDerecha);
				break;
			}
			case KeyEvent.VK_UP: {
				operar(JugadorThread.moverArriba);
				break;
			}
			case KeyEvent.VK_DOWN: {
				operar(JugadorThread.moverAbajo);
				break;
			}/*
			case KeyEvent.VK_SPACE: {
				mijuego.operar(Juego.ponerItem);
				break;
			}*/
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		
	}

	protected synchronized void operar(int op) {
		EntidadMovible personaje = entidadesMovibles.iterator().next();
		switch (op) {
			case moverAbajo: {
				moverAbajo(personaje);
				break;
			}
			case moverIzquierda: {
				moverIzquierda(personaje);
				break;
			}
			case moverDerecha: {
				moverDerecha(personaje);
				break;
			}
			case moverArriba: {
				moverArriba(personaje);
				break;
			}
		}
	}
	
}
