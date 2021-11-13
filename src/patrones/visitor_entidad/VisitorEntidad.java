package patrones.visitor_entidad;

import entidades.movibles.enemigos.EnemigoA;
import entidades.movibles.enemigos.EnemigoB;
import entidades.movibles.enemigos.EnemigoC;
import entidades.movibles.enemigos.EnemigoD;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.items.ItemA;
import entidades.nomovibles.items.ItemB;
import entidades.nomovibles.items.ItemC;
import entidades.nomovibles.items.ItemD;
import entidades.nomovibles.items.ItemE;

public abstract class VisitorEntidad {
	public abstract void visit(ItemA it);

	public abstract void visit(ItemB it);
	
	public abstract void visit(ItemC it);

	public abstract void visit(ItemD it);

	public abstract void visit(ItemE it);
	
	public abstract void visit(EnemigoA enemigo);
	
	public abstract void visit(EnemigoB enemigo);
	
	public abstract void visit(EnemigoC enemigo);
	
	public abstract void visit(EnemigoD enemigo);
	
	public abstract void visit(Jugador jug);
}
