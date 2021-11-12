package Dominio;

import Entidad.Enemigo.Boss;
import Entidad.Enemigo.Circulo;
import Entidad.Enemigo.Cuadrado;
import Entidad.Enemigo.Enemigo;
import Entidad.Enemigo.Triangulo;
import Entidad.Item.Bloque;
import Entidad.Item.Bomba;
import Entidad.Item.Cuchillo;
import Entidad.Item.Dinero;
import Entidad.Item.Energizante;
import Entidad.Item.Galleta;
import Entidad.Item.Item;
import Entidad.Jugador.Jugador;
import Entidad.Jugador.Jugador_456;

public class FactoryJuegoCalamar extends FactoryDominio {

	@Override
	public Jugador crearJugador() {
		return new Jugador_456(null, 0, 0, null);// (new Coordenada(235,441), 100, 3); //agregar valores reales de
													// velocidad y vidas
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
