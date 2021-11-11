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
import Logica.Juego;
import Logica.SalaDeJuegos;

public class Level1Builder extends LevelBuilder {

	public Level1Builder(SalaDeJuegos sj) {
		Coordenada punto = null;
		Entidad entidad = null;
		List<String> toret = LeerArchivo.leer("src\\LevelBuilder\\level1.txt");

		for (int i = 0; i < toret.size() - 1; i++) {
			String palabra = toret.get(i);
			String[] caracter = palabra.split(";");
			
			switch (caracter[i]) {
			case "g": { // galleta
				punto = new Coordenada(Integer.parseInt(caracter[i+1]), Integer.parseInt(caracter[i+2]));
				entidad = new Galleta(1, punto,this.getClass().getResource(caracter[i+3]).toString()); 
				sj.getListaItem().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}

			case "e": { // Creo un energizante
				
				punto = new Coordenada(Integer.parseInt(caracter[i+1]), Integer.parseInt(caracter[i+2]));
				entidad = new Energizante(1, punto, this.getClass().getResource(caracter[i+3]).toString());
				sj.getListaItem().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}

			case "c": { // Creo un cuchillo
				punto = new Coordenada(Integer.parseInt(caracter[i+1]), Integer.parseInt(caracter[i+2]));
				entidad = new Cuchillo(1, punto,this.getClass().getResource(caracter[i+3]).toString());
				sj.getListaItem().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}
			case "d": { // Creo un dinero
				punto = new Coordenada(Integer.parseInt(caracter[i+1]), Integer.parseInt(caracter[i+2]));
				entidad = new Dinero(1, punto,this.getClass().getResource(caracter[i+3]).toString());
				sj.getListaItem().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}

			case "b": { // Creo una bomba
				punto = new Coordenada(Integer.parseInt(caracter[i+1]), Integer.parseInt(caracter[i+2]));
				entidad = new Bomba(1, punto, this.getClass().getResource(caracter[i+3]).toString());
				sj.getListaItem().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}

			case "j": { // Creo un jugador
				punto = new Coordenada(Integer.parseInt(caracter[i+1]), Integer.parseInt(caracter[i+2]));
				entidad = new Jugador_456(punto, 100, 3, this.getClass().getResource(caracter[i+3]).toString());
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}
			case "B": { // Creo un Boss
				punto = new Coordenada(Integer.parseInt(caracter[i+1]), Integer.parseInt(caracter[i+2]));
				entidad = new Boss(punto,this.getClass().getResource(caracter[i+3]).toString());
				sj.getListaEnemigos().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}
			case "C": { // Creo un circulo
				punto = new Coordenada(Integer.parseInt(caracter[i+1]), Integer.parseInt(caracter[i+2]));
				entidad = new Circulo(punto,this.getClass().getResource(caracter[i+3]).toString());
				sj.getListaEnemigos().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}
			case "S": { // Creo un cuadrado
				punto = new Coordenada(Integer.parseInt(caracter[i+1]), Integer.parseInt(caracter[i+2]));
				entidad = new Cuadrado(punto, this.getClass().getResource(caracter[i+3]).toString());
				sj.getListaEnemigos().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}
			case "T": { // Creo un triangulo
				punto = new Coordenada(Integer.parseInt(caracter[i+1]), Integer.parseInt(caracter[i+2]));
				entidad = new Triangulo(punto,this.getClass().getResource(caracter[i+3]).toString());
				sj.getListaEnemigos().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
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
