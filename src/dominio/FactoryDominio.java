package dominio;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.enemigos.EnemigoA;
import entidades.movibles.enemigos.EnemigoB;
import entidades.movibles.enemigos.EnemigoC;
import entidades.movibles.enemigos.EnemigoD;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.Bloque;
import entidades.nomovibles.Item;
import entidades.nomovibles.items.ItemA;
import entidades.nomovibles.items.ItemB;
import entidades.nomovibles.items.ItemC;
import entidades.nomovibles.items.ItemD;
import entidades.nomovibles.items.ItemE;

public  class FactoryDominio {
/*public abstract  Jugador crearJugador();	
public abstract Enemigo crearEnemigoA();
public abstract Enemigo crearEnemigoB();
public abstract Enemigo crearEnemigoC();
public abstract Enemigo crearEnemigoD();
public abstract Item CrearItemA();
public abstract Item CrearItemB();
public abstract Item CrearItemC();
public abstract Item CrearItemD();
public abstract Item CrearItemE();
public abstract Bloque CrearBloque();*/

	public Jugador crearJugador() {		// TODO
		return Jugador.getJugador();// (new Coordenada(235,441), 100, 3); //agregar valores reales de									// velocidad y vidas
												//Esto dentro del constructor privado de Jugador_456.
	}


	public Enemigo crearEnemigoA() {
		return new EnemigoA(null, null);
	}


	public Enemigo crearEnemigoB() {
		return new EnemigoB(null, null);
	}


	public Enemigo crearEnemigoC() {
		return new EnemigoC(null, null);
	}


	public Enemigo crearEnemigoD() {
		return new EnemigoD(null, null);
	}


	public Item CrearItemA() {
		return new ItemA(0, null, null);
	}


	public Item CrearItemB() {
		return new ItemB(0, null, null);
	}


	public Item CrearItemC() {
		return new ItemC(0, null, null);
	}


	public Item CrearItemD() {
		return new ItemD(0, null, null);
	}


	public Item CrearItemE() {
		return new ItemE(0, null, null);
	}


	public Bloque CrearBloque() {
		return new Bloque(null,null,0,0);
	}

}
