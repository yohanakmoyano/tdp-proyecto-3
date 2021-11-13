package dominio;

import entidades.movibles.enemigos.Boss;
import entidades.movibles.enemigos.Circulo;
import entidades.movibles.enemigos.Cuadrado;
import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.enemigos.Triangulo;
import entidades.movibles.jugadores.Jugador;
import entidades.movibles.jugadores.Jugador_456;
import entidades.nomovibles.Bloque;
import entidades.nomovibles.Item;
import entidades.nomovibles.items.Bomba;
import entidades.nomovibles.items.Cuchillo;
import entidades.nomovibles.items.Dinero;
import entidades.nomovibles.items.Energizante;
import entidades.nomovibles.items.Galleta;

public class FactoryJuegoCalamar extends FactoryDominio {

	@Override
	public Jugador crearJugador() {		// TODO
		return Jugador_456.getJugador();// (new Coordenada(235,441), 100, 3); //agregar valores reales de
													// velocidad y vidas
												//Esto dentro del constructor privado de Jugador_456.
	}

	@Override
	public Enemigo crearEnemigoA() {
		return new Boss(null, null);
	}

	@Override
	public Enemigo crearEnemigoB() {
		return new Cuadrado(null, null);
	}

	@Override
	public Enemigo crearEnemigoC() {
		return new Triangulo(null, null);
	}

	@Override
	public Enemigo crearEnemigoD() {
		return new Circulo(null, null);
	}

	@Override
	public Item CrearItemA() {
		return new Galleta(0, null, null);// (1,new Coordenada(163,277));
	}

	@Override
	public Item CrearItemB() {
		return new Cuchillo(0, null, null);// (1,new Coordenada(83,97));
	}

	@Override
	public Item CrearItemC() {
		return new Energizante(0, null, null);// (1,new Coordenada(451,137));
	}

	@Override
	public Item CrearItemD() {
		return new Bomba(0, null, null);// (1,new Coordenada(112,379));
	}

	@Override
	public Item CrearItemE() {
		return new Dinero(0, null, null);// (1,new Coordenada(235,345));
	}

	@Override
	public Bloque CrearBloque() {
		return new Bloque(null,null,0,0);
	}

}
