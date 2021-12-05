package patrones.visitor_entidad;

import java.util.Timer;
import java.util.TimerTask;

import entidades.Entidad;
import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.Bloque;
import entidades.nomovibles.items.ItemA;
import entidades.nomovibles.items.ItemB;
import entidades.nomovibles.items.ItemC;
import entidades.nomovibles.items.ItemD;
import entidades.nomovibles.items.ItemE;
import entidades.nomovibles.items.ItemEfecto;

public class VisitorJugador extends VisitorEntidad {
	protected Jugador miJugador;

	
	public VisitorJugador(Jugador miJug) {
		miJugador = miJug;
	}

	public void visit(Bloque ent) {
		miJugador.comeBack();
	}

	public void visit(ItemA it) {
		miJugador.afectarPuntaje(it.getValor());
		miJugador.setCantItemsLevantados();
		it.eliminar();
	}

	public void visit(ItemB arma) {
		miJugador.afectarPuntaje(arma.getValor());
		miJugador.modoCazaOn();
		miJugador.setCantItemsLevantados();
		arma.eliminar();
		miJugador.setTransformacion(true);
		Timer time = new Timer();
		time.schedule(new TimerTask() {

			@Override
			public void run() {
				miJugador.modoCazaOff();
				miJugador.setTransformacion(false);
			
			}}, 5000);	
		
	}

	public void visit(ItemC potion) {
		int velocidadPrevia = miJugador.getVelocidad();
		miJugador.afectarPuntaje(potion.getValor());
		miJugador.setVelocidad((miJugador.getVelocidad()* 5) / 2);
		potion.eliminar();
		miJugador.setTransformacion(true);
		miJugador.getJuego().getGui().actualizarPocion("+ velocidad");
		Timer time = new Timer();
		time.schedule(new TimerTask() {

			@Override
			public void run() {
				miJugador.setVelocidad(velocidadPrevia);
				miJugador.getJuego().getGui().actualizarPocion("");
				miJugador.setTransformacion(false);
			}}, 6000);
	}

	public void visit(ItemD bomb) {
		bomb.eliminar();
		miJugador.setTransformacion(true);
		Timer time = new Timer();
		miJugador.getJuego().getGui().actualizarPocion("15 seg para explosión");
		time.schedule(new TimerTask() {

			@Override
			public void run() {
				miJugador.getJuego().getGui().actualizarPocion("");
				Entidad efecto = bomb.ponerBomba(miJugador.getPosicion());
				miJugador.tengoUnaBomba(efecto);
				bomb.remover();
				miJugador.setTransformacion(false);	
			}}, 15000);
	}

	public void visit(ItemE it) {
		miJugador.afectarPuntaje(it.getValor());
		it.eliminar();
	}

	public void visit(Enemigo enemigo) {
		enemigo.getEstrategia().atacar();
	}

	public void visit(Jugador jug) {
		
	}

	public void visit(ItemEfecto efect) {
		
	}
}
