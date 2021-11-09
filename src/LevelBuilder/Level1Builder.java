package LevelBuilder;

import java.util.List;

import Entidad.Entidad;
import Entidad.Enemigo.Boss;
import Entidad.Enemigo.Circulo;
import Entidad.Enemigo.Cuadrado;
import Entidad.Enemigo.Triangulo;
import Entidad.Item.Bomba;
import Entidad.Item.Cuchillo;
import Entidad.Item.Dinero;
import Entidad.Item.Energizante;
import Entidad.Item.Galleta;

import Entidad.Jugador.Jugador_456;
import Logica.Coordenada;

public class Level1Builder extends LevelBuilder {

	public Level1Builder() {
		Coordenada punto = null;
		Entidad item = null;
		List<String> toret = LeerArchivo.leer("src\\LevelBuilder\\level1.txt");
		for (int i = 0; i < toret.size() - 1; i++) {
			String palabra = toret.get(i);
			String[] caracter = palabra.split(";");
			switch (caracter[i]) {
			case "g": { // galleta
				punto = new Coordenada(Integer.parseInt(caracter[1]), Integer.parseInt(caracter[2]));
				item = new Galleta(1, punto);
				break;
			}

			case "e": { // Creo un energizante
				punto = new Coordenada(Integer.parseInt(caracter[1]), Integer.parseInt(caracter[2]));
				item = new Energizante(1, punto);
				break;
			}

			case "c": { // Creo un cuchillo
				punto = new Coordenada(Integer.parseInt(caracter[1]), Integer.parseInt(caracter[2]));
				item = new Cuchillo(1, punto);
				break;
			}
			case "d": { // Creo un dinero
				punto = new Coordenada(Integer.parseInt(caracter[1]), Integer.parseInt(caracter[2]));
				item = new Dinero(1, punto);
				break;
			}

			case "b": { // Creo una bomba
				punto = new Coordenada(Integer.parseInt(caracter[1]), Integer.parseInt(caracter[2]));
				item = new Bomba(1, punto);
				break;
			}

			case "j": { // Creo un jugador
				punto = new Coordenada(Integer.parseInt(caracter[1]), Integer.parseInt(caracter[2]));
				item = new Jugador_456(punto, 100, 3);
				break;
			}
			case "B": { // Creo un Boss
				punto = new Coordenada(Integer.parseInt(caracter[1]), Integer.parseInt(caracter[2]));
				item = new Boss(punto);
				break;
			}
			case "C": { // Creo un circulo
				punto = new Coordenada(Integer.parseInt(caracter[1]), Integer.parseInt(caracter[2]));
				item = new Circulo(punto);
				break;
			}
			case "S": { // Creo un cuadrado
				punto = new Coordenada(Integer.parseInt(caracter[1]), Integer.parseInt(caracter[2]));
				item = new Cuadrado(punto);
				break;
			}
			case "T": { // Creo un triangulo
				punto = new Coordenada(Integer.parseInt(caracter[1]), Integer.parseInt(caracter[2]));
				item = new Triangulo(punto);
				break;
			}
			}
		}
	}

	@Override
	public void buildEnemigos() {
		mifabrica.crearEnemigoA();
		mifabrica.crearEnemigoB();
		mifabrica.crearEnemigoC();
		mifabrica.crearEnemigoD();

	}

	@Override
	public void buildItems() {
		mifabrica.CrearItemA();
		mifabrica.CrearItemB();
		mifabrica.CrearItemC();
		mifabrica.CrearItemD();
		mifabrica.CrearItemE();

	}

	@Override
	public void buildPlayer() {
		mifabrica.crearJugador();

	}

}
