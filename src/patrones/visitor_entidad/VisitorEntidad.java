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

public abstract class VisitorEntidad {
	public abstract void visit(Bloque ent);

	public abstract void visit(ItemA it);

	public abstract void visit(ItemB it);

	public abstract void visit(ItemC it);

	public abstract void visit(ItemD it);

	public abstract void visit(ItemE it);

	public abstract void visit(Enemigo enemigo);

	public abstract void visit(Jugador jug);

	public abstract void visit(ItemEfecto efect);
}
