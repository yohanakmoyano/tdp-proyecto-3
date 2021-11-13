package patrones.level_builder;

import java.util.List;

import entidades.Entidad;
import entidades.movibles.enemigos.Boss;
import entidades.movibles.enemigos.Circulo;
import entidades.movibles.enemigos.Cuadrado;
import entidades.movibles.enemigos.Triangulo;
import entidades.movibles.jugadores.Jugador_456;
import entidades.nomovibles.Bloque;
import entidades.nomovibles.items.Bomba;
import entidades.nomovibles.items.Cuchillo;
import entidades.nomovibles.items.Dinero;
import entidades.nomovibles.items.Energizante;
import entidades.nomovibles.items.Galleta;
import logica.Coordenada;
import logica.SalaDeJuegos;

public class Level3Builder extends LevelBuilder {

	public Level3Builder(SalaDeJuegos sj) {
		Coordenada punto = null;
		Entidad entidad = null;
		int j=0;
		List<String> toret = LeerArchivo.leer("src\\patrones\\level_builder\\level3.txt");
		sj.obtenerGui().mostrarImagenFondo(this.getClass().getResource(toret.get(0)).toString());
		for (int i = 1;i < toret.size() ; i++) {
			String palabra = toret.get(i);
			String[] caracter = palabra.split(";");
			switch (caracter[j]) {
			case "p" :{ //bloque pared
				punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
				entidad = new Bloque(punto,this.getClass().getResource(caracter[j+3]).toString(),Integer.parseInt(caracter[j+4]), Integer.parseInt(caracter[j+5])); 
				sj.getListaItem().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
				}
			case "g": { // galleta
				punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
				entidad = new Galleta(1, punto,this.getClass().getResource(caracter[j+3]).toString()); 
				sj.getListaItem().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}

			case "e": { // Creo un energizante
				
				punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
				entidad = new Energizante(1, punto, this.getClass().getResource(caracter[j+3]).toString());
				sj.getListaItem().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}

			case "c": { // Creo un cuchillo
				punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
				entidad = new Cuchillo(1, punto,this.getClass().getResource(caracter[j+3]).toString());
				sj.getListaItem().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}
			case "d": { // Creo un dinero
				punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
				entidad = new Dinero(1, punto,this.getClass().getResource(caracter[j+3]).toString());
				sj.getListaItem().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}

			case "z": { // Creo una bomba
				punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
				entidad = new Bomba(1, punto, this.getClass().getResource(caracter[j+3]).toString());
				sj.getListaItem().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}

			case "j": { // Creo un jugador
				punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
				entidad = new Jugador_456(punto, 100, 3, this.getClass().getResource(caracter[j+3]).toString());
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}
			case "B": { // Creo un Boss
				punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
				entidad = new Boss(punto,this.getClass().getResource(caracter[j+3]).toString());
				sj.getListaEnemigos().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}
			case "C": { // Creo un circulo
				punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
				entidad = new Circulo(punto,this.getClass().getResource(caracter[j+3]).toString());
				sj.getListaEnemigos().add(entidad);
				sj.obtenerGui().mostrarEntidad(entidad);
				break;
			}
			case "S": { // Creo un cuadrado
				punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
				entidad = new Cuadrado(punto, this.getClass().getResource(caracter[j+3]).toString());
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