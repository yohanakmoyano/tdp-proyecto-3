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
		Timer time = new Timer();
		time.schedule(new TimerTask() {

			@Override
			public void run() {
				miJugador.getEstrategia().setStrategy(new Presa(miJugador));
				miJugador.setTransformacion(false);
			
			}}, 4000);	
	}

	public void visit(ItemC potion) {
		int velocidadPrevia = miJugador.getVelocidad();
		miJugador.afectarPuntaje(potion.getValor());
		miJugador.setVelocidad((miJugador.getVelocidad()* 7) / 2);
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
			}}, 4000);
	}

	public void visit(ItemD bomb) {
		//miJugador.tieneItemD();
		bomb.eliminar();
		miJugador.setTransformacion(true);
		miJugador.getJuego().getGui().actualizarPocion("1 explosivo");
		Timer time = new Timer();
		time.schedule(new TimerTask() {

			@Override
			public void run() {
				miJugador.getJuego().getGui().actualizarPocion("");
				Entidad efecto = bomb.ponerBomba(miJugador.getPosicion());
				miJugador.tengoUnaBomba(efecto);
				bomb.remover();
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

	public void visit(ItemEfecto efect) {
		
	}
}
