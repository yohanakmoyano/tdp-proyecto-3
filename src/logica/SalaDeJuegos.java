package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import entidades.Entidad;
import entidades.movibles.EntidadMovible;
import grafica.Gui;

public class SalaDeJuegos {

	protected Zona matrizZonas[][]; 
	protected static final int base=501; 
	protected static final int altura=553; 
	protected int cantDivisiones = 4;
	protected List<Entidad> listaEnemigos; 
	protected List<Entidad> listaEntidadFija; 
	protected List<Entidad> listaJugador; 
	protected Gui miGui;
	protected Juego juego;
	
	public SalaDeJuegos(Gui g, Juego jueg) {
		int incrementX = base/cantDivisiones;
		int incrementY = altura/cantDivisiones;
		int baseX=0;
		int alturaY=0;
		int casoEspecialAncho = base-((cantDivisiones-1)*incrementX);
		int casoEspecialAlto = altura-((cantDivisiones-1)*incrementY);
		matrizZonas=new Zona[cantDivisiones][cantDivisiones];
		for(int i=0; i<cantDivisiones; i++) {
			for(int j=0; j<cantDivisiones; j++) {
				if((i == (cantDivisiones - 1)) || (j == (cantDivisiones - 1))) { //Caso Especial
					if((i == cantDivisiones - 1) && (j == cantDivisiones -1)) {
						matrizZonas[i][j] = new Zona(baseX, alturaY, casoEspecialAncho, casoEspecialAlto);
					} else {
						if(i == cantDivisiones - 1) {
							matrizZonas[i][j] = new Zona(baseX, alturaY, casoEspecialAncho, incrementY);
						} else {
							matrizZonas[i][j] = new Zona(baseX, alturaY, incrementX, casoEspecialAlto);
						}
					}
				} else {
					matrizZonas[i][j] = new Zona(baseX, alturaY, incrementX, incrementY);
				}
				baseX=baseX+incrementX + 1;
				
			}
			
			baseX=0;
			alturaY=alturaY+incrementY + 1; 
			
		}
		
		listaEnemigos= new ArrayList<Entidad>(); 
		listaEntidadFija= new ArrayList<Entidad>(); 
		listaJugador= new ArrayList<Entidad>(); 
		miGui=g;
		juego=jueg;
		
	}
	
	public Gui obtenerGui() {
		return miGui;
	}
	
	/**
	 * Consulta cual es la zona que contiene al punto PUNTO.
	 * @param punto para el cual buscar zona.
	 * @return Zona que contiene a punto.
	 */
	public Zona getZona(Coordenada punto) {
		boolean encontre = false;
		Zona toRet = null;
		for(int i = 0; i<cantDivisiones && !encontre; i++) {
			for(int j = 0; j<cantDivisiones && !encontre; j++) {
				encontre = matrizZonas[i][j].contains(punto.getX(), punto.getY());
				if(encontre)
					toRet = matrizZonas[i][j];
			}
		}
		return toRet;
	}

	//Modificar autorizaciones
	public boolean autorizarMovArriba(EntidadMovible e) {
		System.out.println("Comprobo Mover Arriba");
		return ((e.getEsquinaSupIzq().getY()-(e.getAlto()/2)) > 0);
	}
	
	public boolean autorizarMovAbajo(EntidadMovible e) {
		System.out.println("Comprobo Mover Abajo");
		return ((e.getEsquinaSupIzq().getY() + (e.getAlto()/2)) < altura);
	}
	
	public boolean autorizarMovDerecha(EntidadMovible e) {
		System.out.println("Comprobo Mover Derecha");
		return ((e.getEsquinaSupIzq().getX() + (e.getAncho()/2)) < base);
	}
	
	public boolean autorizarMovIzquierda(EntidadMovible e) {
		System.out.println("Comprobo Mover Izquierda");
		return ((e.getEsquinaSupIzq().getX() - (e.getAncho()/2)) > 0);
	}
	
	public List<Entidad> getListaEnemigos(){
		return listaEnemigos;
	}
	
	public List<Entidad> getListaEntidadFija(){
		return listaEntidadFija;
	}
	
	public List<Entidad> getListJugador() {
		return listaJugador;
	}
	
	
}
