package patrones.visitor_entidad;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.Bloque;
import entidades.nomovibles.items.ItemA;
import entidades.nomovibles.items.ItemB;
import entidades.nomovibles.items.ItemC;
import entidades.nomovibles.items.ItemD;
import entidades.nomovibles.items.ItemE;

public abstract class VisitorEntidad {
	public abstract void visit(Bloque ent);
	
	public abstract void visit(ItemA it);

	public abstract void visit(ItemB it);
	
	public abstract void visit(ItemC it);

	public abstract void visit(ItemD it);

	public abstract void visit(ItemE it);
	
	public abstract void visit(Enemigo enemigo);
	
	public abstract void visit(Jugador jug);
}
