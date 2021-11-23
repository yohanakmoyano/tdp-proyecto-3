package patrones.visitor_entidad;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.Bloque;
import entidades.nomovibles.items.ItemA;
import entidades.nomovibles.items.ItemB;
import entidades.nomovibles.items.ItemC;
import entidades.nomovibles.items.ItemD;
import entidades.nomovibles.items.ItemE;

public class VisitorEnemigo extends VisitorEntidad{
	protected Enemigo miEnemigo;
	
	public VisitorEnemigo(Enemigo miEnem) {
		miEnemigo = miEnem;
	}

	public void visit(Bloque ent) {
		
	}
	
	public void visit(ItemA it) {
		
	}

	public void visit(ItemB it) {
		
	}
	
	public void visit(ItemC it) {
		
	}

	public void visit(ItemD it) {
		
	}

	public void visit(ItemE it) {
		
	}
	
	public void visit(Enemigo enemigo) {
		
	}
	
	public void visit(Jugador jug) {
		jug.getEstrategia().atacar(miEnemigo);
	}
	
}
