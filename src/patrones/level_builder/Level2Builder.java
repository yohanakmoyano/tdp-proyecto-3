package patrones.level_builder;

import java.util.List;

import entidades.Entidad;
import entidades.movibles.enemigos.EnemigoA;
import entidades.movibles.enemigos.EnemigoB;
import entidades.movibles.enemigos.EnemigoC;
import entidades.movibles.enemigos.EnemigoD;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.Bloque;
import entidades.nomovibles.items.ItemA;
import entidades.nomovibles.items.ItemB;
import entidades.nomovibles.items.ItemC;
import entidades.nomovibles.items.ItemD;
import entidades.nomovibles.items.ItemE;
import logica.Coordenada;
import logica.SalaDeJuegos;

public class Level2Builder extends LevelBuilder {

	
	public Level2Builder(SalaDeJuegos sj, int d) {
		Coordenada punto = null;
		Entidad entidad = null;
		int j=0;
		List<String> toret =null;
		
		//Lee del txt el fondo del lvl2 de los diferentes Dominios
		if (d==1)
			toret= LeerArchivo.leer("src\\patrones\\level_builder\\level2JDC.txt");
		if (d==2)
			toret = LeerArchivo.leer("src\\patrones\\level_builder\\level2AU.txt");
		if (d==3)
			toret = LeerArchivo.leer("src\\patrones\\level_builder\\level2PM.txt");
		sj.obtenerGui().mostrarImagenFondo(this.getClass().getResource(toret.get(0)).toString());
		musica=this.getClass().getResource(toret.get(1).toString());
		//Lee del txt las entidades y las agrega al mapa
		for (int i = 2;i < toret.size() ; i++) {
			String palabra = toret.get(i);
			String[] caracter = palabra.split(";");
			punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
			
			switch (caracter[j]) {
			
				case "p" :{ //bloque pared
					entidad = new Bloque(punto,this.getClass().getResource(caracter[j+3]).toString(),Integer.parseInt(caracter[j+4]), Integer.parseInt(caracter[j+5])); 
					sj.getListaEntidadFija().add(entidad);
					break;	
				}
				case "g": { // galleta
					entidad = new ItemA(1, punto,this.getClass().getResource(caracter[j+3]).toString()); 
					sj.getListaEntidadFija().add(entidad);
					break;
				}
				case "e": { // Creo un energizante
					entidad = new ItemC(1, punto, this.getClass().getResource(caracter[j+3]).toString());
					sj.getListaEntidadFija().add(entidad);
					break;
				}
				case "c": { // Creo un cuchillo
					entidad = new ItemB(1, punto,this.getClass().getResource(caracter[j+3]).toString());
					sj.getListaEntidadFija().add(entidad);
					break;
				}
				case "d": { // Creo un dinero
					entidad = new ItemE(1, punto,this.getClass().getResource(caracter[j+3]).toString());
					sj.getListaEntidadFija().add(entidad);
					break;
				}
				case "z": { // Creo una bomba
					entidad = new ItemD(1, punto, this.getClass().getResource(caracter[j+3]).toString());
					sj.getListaEntidadFija().add(entidad);
					break;
				}
				case "j": { // Creo un jugador
					entidad = Jugador.getJugador( punto, 100,3,this.getClass().getResource(caracter[j+3]).toString());
							//new Jugador(punto, 100, 3, this.getClass().getResource(caracter[j+3]).toString());
					sj.getListJugador().add(entidad);
					break;
				}
				case "B": { // Creo un Boss
					entidad = new EnemigoA(punto,this.getClass().getResource(caracter[j+3]).toString());
					sj.getListaEnemigos().add(entidad);
					break;
				}
				case "C": { // Creo un circulo
					entidad = new EnemigoD(punto,this.getClass().getResource(caracter[j+3]).toString());
					sj.getListaEnemigos().add(entidad);
					break;
				}
				case "S": { // Creo un cuadrado
					entidad = new EnemigoB(punto, this.getClass().getResource(caracter[j+3]).toString());
					sj.getListaEnemigos().add(entidad);
					break;
				}
				case "T": { // Creo un triangulo
					entidad = new EnemigoC(punto,this.getClass().getResource(caracter[j+3]).toString());
					sj.getListaEnemigos().add(entidad);
					break;
				}
			}
			
			sj.obtenerGui().mostrarEntidad(entidad);
			sj.agregarAZonas(entidad);
			
		}
	}
	/*@Override
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
		
	}*/

}
