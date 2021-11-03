package VisitorEntidad;

import Entidad.Enemigo;
import Entidad.Item;
import Entidad.Jugador;

public abstract class VisitorEntidad {
public abstract void visit(Item it);
public abstract void visit(Enemigo enemigo);
public abstract void visit(Jugador jugador);

}
