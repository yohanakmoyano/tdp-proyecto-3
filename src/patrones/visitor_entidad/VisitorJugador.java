package patrones.visitor_entidad;

import java.util.Timer;
import java.util.TimerTask;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.Bloque;
import entidades.nomovibles.items.ItemA;
import entidades.nomovibles.items.ItemB;
import entidades.nomovibles.items.ItemC;
import entidades.nomovibles.items.ItemD;
import entidades.nomovibles.items.ItemE;
import patrones.strategy.Cazador;
import patrones.strategy.Presa;

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
		miJugador.getEstrategia().setStrategy(new Cazador(miJugador));
		miJugador.setCantItemsLevantados();
		arma.eliminar();
		miJugador.setTransformacion(true);
		miJugador.setVelocidad(5);
		Timer time = new Timer();
		time.schedule(new TimerTask() {

			@Override
			public void run() {
				miJugador.setVelocidad(1);
				miJugador.getEstrategia().setStrategy(new Presa(miJugador));
				miJugador.setTransformacion(false);
			}}, 2000);	
	}

	public void visit(ItemC potion) {
		miJugador.afectarPuntaje(potion.getValor());
		miJugador.setVelocidad((miJugador.getVelocidad()* 3) / 2);
		miJugador.setVelocidad(5);
		potion.eliminar();
		miJugador.setTransformacion(true);
		Timer time = new Timer();
		time.schedule(new TimerTask() {

			@Override
			public void run() {
				miJugador.setVelocidad(1);
				miJugador.setTransformacion(false);
			}}, 2000);
	}

	public void visit(ItemD bomb) {
		miJugador.tieneItemD();
		bomb.eliminar();
		miJugador.setTransformacion(true);
		Timer time = new Timer();
		time.schedule(new TimerTask() {

			@Override
			public void run() {
				bomb.ponerBomba(miJugador.getPosicion());
				miJugador.setTransformacion(false);
				
			}}, 3000);
	}

	public void visit(ItemE it) {
		miJugador.afectarPuntaje(it.getValor());
		it.eliminar();
	}

	public void visit(Enemigo enemigo) {
		miJugador.getEstrategia().atacar(enemigo);
	}

	public void visit(Jugador jug) {

	}
}
