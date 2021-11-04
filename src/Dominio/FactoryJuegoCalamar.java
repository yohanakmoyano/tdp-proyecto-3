package Dominio;

import Entidad.Enemigo.Boss;
import Entidad.Enemigo.Circulo;
import Entidad.Enemigo.Cuadrado;
import Entidad.Enemigo.Enemigo;
import Entidad.Enemigo.Triangulo;
import Entidad.Item.Bomba;
import Entidad.Item.Cuchillo;
import Entidad.Item.Dinero;
import Entidad.Item.Energizante;
import Entidad.Item.Galleta;
import Entidad.Item.Item;
import Entidad.Jugador.Jugador;
import Entidad.Jugador.Jugador_456;
import Logica.Coordenada;

public class FactoryJuegoCalamar extends FactoryDominio {

	@Override
	public Jugador crearJugador() {
		return new Jugador_456(null, 0, 0);
	}

	@Override
	public Enemigo crearEnemigoA() {
		return new Boss();
	}

	@Override
	public Enemigo crearEnemigoB() {
		return new Cuadrado();
	}

	@Override
	public Enemigo crearEnemigoC() {
		return new Triangulo();
	}

	@Override
	public Enemigo crearEnemigoD() {
		return new Circulo();
	}

	@Override
	public Item CrearItemA() {
		return new Galleta(5,new Coordenada(2,4));
	}

	@Override
	public Item CrearItemB() {
		return new Cuchillo(5,new Coordenada(5,7));
	}

	@Override
	public Item CrearItemC() {
		return new Energizante(5,new Coordenada(5,7));
	}

	@Override
	public Item CrearItemD() {
		return new Bomba(5,new Coordenada(5,7));
	}

	@Override
	public Item CrearItemE() {
		return new Dinero(5,new Coordenada(5,7));
	}
	
}
