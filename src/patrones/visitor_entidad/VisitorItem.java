package patrones.visitor_entidad;

import entidades.movibles.enemigos.EnemigoA;
import entidades.movibles.enemigos.EnemigoB;
import entidades.movibles.enemigos.EnemigoC;
import entidades.movibles.enemigos.EnemigoD;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.Item;
import entidades.nomovibles.items.ItemA;
import entidades.nomovibles.items.ItemB;
import entidades.nomovibles.items.ItemC;
import entidades.nomovibles.items.ItemD;
import entidades.nomovibles.items.ItemE;

public class VisitorItem extends VisitorEntidad {
	protected Item miItem;
	
	public VisitorItem(Item miIt) {
		miItem = miIt;
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
	
	public void visit(EnemigoA enemigo) {
		
	}
	
	public void visit(EnemigoB enemigo) {
		
	}
	
	public void visit(EnemigoC enemigo) {
		
	}
	
	public void visit(EnemigoD enemigo) {
		
	}
	
	public void visit(Jugador jug) {
		
	}
}
