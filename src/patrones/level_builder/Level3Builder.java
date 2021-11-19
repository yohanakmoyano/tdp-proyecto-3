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

public class Level3Builder extends LevelBuilder {

	public Level3Builder(SalaDeJuegos sj,int d) {
		Coordenada punto = null;
		Entidad entidad = null;
		int j=0;
		List<String> toret =null;
		if (d==1)
			toret= LeerArchivo.leer("src\\patrones\\level_builder\\level3JDC.txt");
			if (d==2)
				 toret = LeerArchivo.leer("src\\patrones\\level_builder\\level3AU.txt");
			if (d==3)
				toret = LeerArchivo.leer("src\\patrones\\level_builder\\level3PM.txt");
		sj.obtenerGui().mostrarImagenFondo(this.getClass().getResource(toret.get(0)).toString());
		//Lee del txt las entidades y las agrega al mapa
				for (int i = 1;i < toret.size() ; i++) {
					String palabra = toret.get(i);
					String[] caracter = palabra.split(";");
					//TODO
					//Repeticion codigo punto y mostrarEntidad
					switch (caracter[j]) {
					
						case "p" :{ //bloque pared
							punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
							entidad = new Bloque(punto,this.getClass().getResource(caracter[j+3]).toString(),Integer.parseInt(caracter[j+4]), Integer.parseInt(caracter[j+5])); 
							sj.getListaEntidadFija().add(entidad);
							sj.obtenerGui().mostrarEntidad(entidad);
							break;
							
						}
						
						case "g": { // galleta
							punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
							entidad = new ItemA(1, punto,this.getClass().getResource(caracter[j+3]).toString()); 
							sj.getListaEntidadFija().add(entidad);
							sj.obtenerGui().mostrarEntidad(entidad);
							break;
						}
				
						case "e": { // Creo un energizante
							
							punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
							entidad = new ItemC(1, punto, this.getClass().getResource(caracter[j+3]).toString());
							sj.getListaEntidadFija().add(entidad);
							sj.obtenerGui().mostrarEntidad(entidad);
							break;
						}
				
						case "c": { // Creo un cuchillo
							punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
							entidad = new ItemB(1, punto,this.getClass().getResource(caracter[j+3]).toString());
							sj.getListaEntidadFija().add(entidad);
							sj.obtenerGui().mostrarEntidad(entidad);
							break;
						}
						case "d": { // Creo un dinero
							punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
							entidad = new ItemE(1, punto,this.getClass().getResource(caracter[j+3]).toString());
							sj.getListaEntidadFija().add(entidad);
							sj.obtenerGui().mostrarEntidad(entidad);
							break;
						}
				
						case "z": { // Creo una bomba
							punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
							entidad = new ItemD(1, punto, this.getClass().getResource(caracter[j+3]).toString());
							sj.getListaEntidadFija().add(entidad);
							sj.obtenerGui().mostrarEntidad(entidad);
							break;
						}
				
						case "j": { // Creo un jugador
							punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
							entidad = new Jugador(punto, 100, 3, this.getClass().getResource(caracter[j+3]).toString());
							sj.getListJugador().add(entidad);
							sj.obtenerGui().mostrarEntidad(entidad);
							break;
						}
						case "B": { // Creo un Boss
							punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
							entidad = new EnemigoA(punto,this.getClass().getResource(caracter[j+3]).toString());
							sj.getListaEnemigos().add(entidad);
							sj.obtenerGui().mostrarEntidad(entidad);
							break;
						}
						case "C": { // Creo un circulo
							punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
							entidad = new EnemigoD(punto,this.getClass().getResource(caracter[j+3]).toString());
							sj.getListaEnemigos().add(entidad);
							sj.obtenerGui().mostrarEntidad(entidad);
							break;
						}
						case "S": { // Creo un cuadrado
							punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
							entidad = new EnemigoB(punto, this.getClass().getResource(caracter[j+3]).toString());
							sj.getListaEnemigos().add(entidad);
							sj.obtenerGui().mostrarEntidad(entidad);
							break;
						}
						case "T": { // Creo un triangulo
							punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]));
							entidad = new EnemigoC(punto,this.getClass().getResource(caracter[j+3]).toString());
							sj.getListaEnemigos().add(entidad);
							sj.obtenerGui().mostrarEntidad(entidad);
							break;
						}
					}
					
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
