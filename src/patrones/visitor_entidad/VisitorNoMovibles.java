package patrones.visitor_entidad;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.Bloque;
import entidades.nomovibles.EntidadNoMovible;
import entidades.nomovibles.items.ItemA;
import entidades.nomovibles.items.ItemB;
import entidades.nomovibles.items.ItemC;
import entidades.nomovibles.items.ItemD;
import entidades.nomovibles.items.ItemE;
import entidades.nomovibles.items.ItemEfecto;

public class VisitorNoMovibles extends VisitorEntidad {
	protected EntidadNoMovible me;
	
	public VisitorNoMovibles(EntidadNoMovible me) {
		this.me = me;
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
		jug.afectarPuntaje(me.getValor());
	}

	@Override
	public void visit(ItemEfecto efect) {
		
	}
}
