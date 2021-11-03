package VisitorEntidad;

import Entidad.Enemigo.Enemigo;
import Entidad.Item.Item;
import Entidad.Jugador.Jugador;

public abstract class VisitorEntidad {
	public abstract void visit(Item it);
	public abstract void visit(Enemigo enemigo);
	public abstract void visit(Jugador jugador);

}
