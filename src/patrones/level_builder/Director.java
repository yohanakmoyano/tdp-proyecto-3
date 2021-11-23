package patrones.level_builder;


import java.net.URL;
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

public class Director {

	protected int nivel;
	//pasar la fabrica directamentamente o alguna forma de idenficar como atributo o contructor
	protected SalaDeJuegos sj;
	protected String fileName;
	protected URL musica;
	
	public void reset() {

	}
	public URL getMusica(){
		return musica;
	}
	
	public Director(int n, SalaDeJuegos sj,int d) {
		nivel=n;
		Coordenada punto = null;
		Entidad entidad = null;
		int j=0;
		List<String> toret =null;
		int cantItems = 0;
		
		//Lee del txt el fondo del lvl1 de los diferentes Dominios
		if (d==1) {
			if (n==1) {
				punto=new Coordenada(240,390);
				toret= LeerArchivo.leer("src\\patrones\\level_builder\\level1JDC.txt");
			}
			if (n==2) {
				punto=new Coordenada(222,410);
			toret= LeerArchivo.leer("src\\patrones\\level_builder\\level2JDC.txt");
			}
			if (n==3) {
				punto=new Coordenada(240,380);
				toret= LeerArchivo.leer("src\\patrones\\level_builder\\level3JDC.txt");
			}
		}
		if (d==2) {
			if (n==1) {
				punto=new Coordenada(240,390);
			toret = LeerArchivo.leer("src\\patrones\\level_builder\\level1AU.txt");
			}
			if (n==2) {
				punto=new Coordenada(222,410);
				toret = LeerArchivo.leer("src\\patrones\\level_builder\\level2AU.txt");
			}
			if (n==3) {
				punto=new Coordenada(240,380);
				toret = LeerArchivo.leer("src\\patrones\\level_builder\\level3AU.txt");
			}
		}
		if (d==3) {
			if (n==1) {
				punto=new Coordenada(240,390);
			toret = LeerArchivo.leer("src\\patrones\\level_builder\\level1PM.txt");
			}
			if (n==2) {
				punto=new Coordenada(222,410);
				toret = LeerArchivo.leer("src\\patrones\\level_builder\\level2PM.txt");
			}
				if (n==3) {
					punto=new Coordenada(240,380);
					toret = LeerArchivo.leer("src\\patrones\\level_builder\\level3PM.txt");
				}
		}
		sj.obtenerGui().mostrarImagenFondo(this.getClass().getResource(toret.get(0)).toString());
		musica=this.getClass().getResource(toret.get(1).toString());
	    // Creo un jugador
		Jugador jug = Jugador.getJugador(punto,100,3,this.getClass().getResource(toret.get(2)).toString());
		sj.obtenerGui().mostrarEntidad(jug);
		sj.getListJugador().add(jug);
	
		//Lee del txt las entidades y las agrega al mapa
		for (int i = 3;i < toret.size() ; i++) {
			String palabra = toret.get(i);
			String[] caracter = palabra.split(";");
			punto = new Coordenada(Integer.parseInt(caracter[j+1]), Integer.parseInt(caracter[j+2]) );
			
			switch (caracter[j]) {
			
				case "p" :{ //bloque pared	
					entidad = new Bloque(punto, this.getClass().getResource(caracter[j+3]).toString(),Integer.parseInt(caracter[j+4]), Integer.parseInt(caracter[j+5])); 
					sj.getListaEntidadFija().add(entidad);
					break;
				}
				case "g": { // galleta
					entidad = new ItemA(1, punto,this.getClass().getResource(caracter[j+3]).toString()); 
					sj.getListaEntidadFija().add(entidad);
					//System.out.println("cantidad de monedas " + cantItemsA);
					cantItems++;	
					sj.setCantItems(cantItems);
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
					cantItems++;	
					sj.setCantItems(cantItems);
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
			
		/*if (nivel==1) 
			builder=new Level1Builder(sj,j);
		
		if (nivel==2)
			builder=new Level2Builder(sj,j);
		
		if (nivel==3)
			builder=new Level3Builder(sj,j);	*/
	}
	
	
	public void changeLevel(int nvl) {
		nivel=nvl;
		
	}

}
