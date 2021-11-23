package niveles;

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
	protected SalaDeJuegos sj;
	protected String fileName;
	protected URL musica;
	//pasar la fabrica directamentamente o alguna forma de idenficar como atributo o contructor
		
	
	public Director(int n, SalaDeJuegos sj, int dominio) {
		Coordenada punto = null;
		Entidad entidad = null;
		List<String> toRet = null;
		int cantItems = 0;
		nivel = n;
		int j = 0;
		
		//Acomodar como abrir el punto correspondiente
		//Dependiendo del dominio lee el txt correspondiente
		if (dominio == 1) {
			punto = new Coordenada(240, 390);
			toRet = LeerArchivo.leer("src\\niveles\\level"+n+"JDC.txt");	
			}
		
		if (dominio == 2) {
			punto = new Coordenada(240, 390);
			toRet = LeerArchivo.leer("src\\niveles\\level"+n+"AU.txt");
			}
		
		if (dominio == 3) {
			punto = new Coordenada(240, 390);
			toRet = LeerArchivo.leer("src\\niveles\\level"+n+"PM.txt");
			}
			
		sj.obtenerGui().mostrarImagenFondo(this.getClass().getResource(toRet.get(0)).toString());
		musica = this.getClass().getResource(toRet.get(1).toString());
	    // Creo un jugador
		Jugador jug = Jugador.getJugador(punto,100,3,this.getClass().getResource(toRet.get(2)).toString());
		sj.obtenerGui().mostrarEntidad(jug);
		sj.getListJugador().add(jug);
	
		//Lee del txt las entidades y las agrega al mapa
		for (int i = 3;i < toRet.size() ; i++) {
			String palabra = toRet.get(i);
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
	
	public void reset() {

	}
	
	public URL getMusica(){
		return musica;
	}
	
	public void changeLevel(int nvl) {
		nivel = nvl;
		
	}

}
