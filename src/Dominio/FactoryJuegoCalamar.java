package Dominio;

import Entidad.Enemigo;
import Entidad.Item;
import Entidad.Jugador;
import Logica.Bomba;
import Logica.Boss;
import Logica.Circulo;
import Logica.Cuadrado;
import Logica.Cuchillo;
import Logica.Dinero;
import Logica.Energizante;
import Logica.Galleta;
import Logica.Jugador_456;
import Logica.Triangulo;
import Logica.Zona;

public class FactoryJuegoCalamar extends FactoryDominio {

	@Override
	public Jugador crearJugador() {
		return new Jugador_456();
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
		return new Galleta(5,new Zona(2,4));
	}

	@Override
	public Item CrearItemB() {
		return new Cuchillo(5,new Zona(5,7));
	}

	@Override
	public Item CrearItemC() {
		return new Energizante(5,new Zona(5,7));
	}

	@Override
	public Item CrearItemD() {
		return new Bomba(5,new Zona(5,7));
	}

	@Override
	public Item CrearItemE() {
		return new Dinero(5,new Zona(5,7));
	}
	
}
