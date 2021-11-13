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
		// TODO Auto-generated method stub
		
	}
	
	public void visit(ItemA it) {
		miJugador.afectarPuntaje(it.getValor());
	}

	public void visit(ItemB it) {
		miJugador.afectarPuntaje(it.getValor());
		miJugador.getEstrategia().setStrategy(new Cazador(miJugador));
	}
	
	public void visit(ItemC it) {
		miJugador.afectarPuntaje(it.getValor());
		miJugador.setVelocidad((miJugador.getVelocidad()*3)/2); //Algo simil a multiplicarlo por un factor de 1.5
	}

	public void visit(ItemD it) {
		// TODO definir comportamiento de la bomba.
	}

	public void visit(ItemE it) {
		miJugador.afectarPuntaje(it.getValor());
	}
	
	public void visit(Enemigo enemigo) {
		miJugador.getEstrategia().atacar(enemigo);
	}
	
	public void visit(Jugador jug) {
		
	}
}
