package patrones.visitor_entidad;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.Bloque;
import entidades.nomovibles.items.ItemA;
import entidades.nomovibles.items.ItemB;
import entidades.nomovibles.items.ItemC;
import entidades.nomovibles.items.ItemD;
import entidades.nomovibles.items.ItemE;
import patrones.strategy.Cazador;

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

	public void visit(ItemB it) {
		miJugador.afectarPuntaje(it.getValor());
		miJugador.getEstrategia().setStrategy(new Cazador(miJugador));
		miJugador.setCantItemsLevantados();
		it.eliminar();
		miJugador.setTransformacion(true);
	}

	public void visit(ItemC it) {
		miJugador.afectarPuntaje(it.getValor());
		miJugador.setVelocidad((miJugador.getVelocidad()* 3) / 2);
		it.eliminar();
		miJugador.setTransformacion(true);
	}

	public void visit(ItemD it) {
		miJugador.tieneItemD();
		it.eliminar();
		miJugador.setTransformacion(true);
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
