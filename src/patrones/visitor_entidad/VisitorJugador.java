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
		miJugador.resetearMovimientos();
		switch(miJugador.getUltMovimiento()) {
			case(Jugador.ultMovDer): {
				miJugador.setPuedoMovermeDer(false);
				break;
			}
			case(Jugador.ultMovIzq): {
				miJugador.setPuedoMovermeIzq(false);
				break;
			}
			case(Jugador.ultMovUp): {
				miJugador.setPuedoMovermeUp(false);
				break;
			}
			case(Jugador.ultMovDown): {
				miJugador.setPuedoMovermeDown(false);
				break;
			}
		}
		//System.out.println("--------------------------Visite bloque-------------------------------------------------------------");
	}
	
	public void visit(ItemA it) {
		//System.out.println("--------------------------Visite galleta-------------------------------------------------------------");
		miJugador.afectarPuntaje(it.getValor());
		it.eliminar();
	}

	public void visit(ItemB it) {
		//System.out.println("--------------------------Visite cuchillo-------------------------------------------------------------");
		miJugador.afectarPuntaje(it.getValor());
		miJugador.getEstrategia().setStrategy(new Cazador(miJugador));
		it.eliminar();
	}
	
	public void visit(ItemC it) {
		//System.out.println("--------------------------Visite energizante-------------------------------------------------------------");
		miJugador.afectarPuntaje(it.getValor());
		miJugador.setVelocidad((miJugador.getVelocidad()*3)/2); //Algo simil a multiplicarlo por un factor de 1.5
		it.eliminar();
	}

	public void visit(ItemD it) {
		//System.out.println("--------------------------Visite bomba-------------------------------------------------------------");
		// TODO definir comportamiento de la bomba.
		miJugador.tieneItemD();
		it.eliminar();
	}

	public void visit(ItemE it) {
		//System.out.println("--------------------------Visite dolar-------------------------------------------------------------");
		miJugador.afectarPuntaje(it.getValor());
		it.eliminar();
	}
	
	public void visit(Enemigo enemigo) {
		//System.out.println("--------------------------Visite enemigo-------------------------------------------------------------");
		//miJugador.getEstrategia().atacar(enemigo);
		//enemigo.morir();
		miJugador.getEstrategia().atacar(enemigo);
	}
	
	public void visit(Jugador jug) {
		
	}
}
