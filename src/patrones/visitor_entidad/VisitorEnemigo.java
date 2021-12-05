package patrones.visitor_entidad;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.Bloque;
import entidades.nomovibles.ItemA;
import entidades.nomovibles.ItemB;
import entidades.nomovibles.ItemC;
import entidades.nomovibles.ItemD;
import entidades.nomovibles.ItemE;
import entidades.nomovibles.ItemEfecto;

public class VisitorEnemigo extends VisitorEntidad{
	protected Enemigo miEnemigo;
	
	public VisitorEnemigo(Enemigo miEnem) {
		miEnemigo = miEnem;
	}

	public void visit(Bloque ent) {
		miEnemigo.comeBack();
	}
	
	public void visit(ItemA it) {
		
	}

	public void visit(ItemB it) {
		
	}
	
	public void visit(ItemC it) {
		
	}

	public void visit(ItemD bomb) {
		
	}

	public void visit(ItemE it) {
		
	}
	
	public void visit(Enemigo enemigo) {
		
	}
	
	public void visit(Jugador jug) {
		miEnemigo.getEstrategia().atacar();
	}

	public void visit(ItemEfecto efect) {
		miEnemigo.morir();
	}
	
}
