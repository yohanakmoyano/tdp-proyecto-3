package logica;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import entidades.Entidad;
import entidades.movibles.EntidadMovible;
import entidades.movibles.jugadores.Jugador;
import grafica.Gui;
import patrones.visitor_entidad.VisitorJugador;

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
	private Zona getZona(Coordenada punto) {
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
		System.out.println("Puede mover => "+((e.getEsquinaSupIzq().getY() - (e.getAlto()/2)) > 0));
		return ((e.getEsquinaSupIzq().getY() - (e.getAlto()/2)) > 0);
	}
	
	public boolean autorizarMovAbajo(EntidadMovible e) {
		System.out.println("Puede mover => "+((e.getEsquinaSupIzq().getY() + (e.getAlto()/2)) < altura));
		return ((e.getEsquinaSupIzq().getY() + (e.getAlto()/2)) < altura);
	}
	
	public boolean autorizarMovDerecha(EntidadMovible e) {
		System.out.println("Puede mover => " + ((e.getEsquinaSupIzq().getX() + (e.getAncho()/2)) < base));
		return ((e.getEsquinaSupIzq().getX() + (e.getAncho()/2)) < base);
	}
	
	public boolean autorizarMovIzquierda(EntidadMovible e) {
		System.out.println("Puede mover => " + ((e.getEsquinaSupIzq().getX() - (e.getAncho()/2)) > 0));
		return ((e.getEsquinaSupIzq().getX() - (e.getAncho()/2)) > 0);
	}
	
	public void agregarAZonas(Entidad e) {
		Coordenada esqSupIzq = e.getEsquinaSupIzq();
		Coordenada esqSupDer = e.getEsquinaSupDer();
		Coordenada esqInfIzq = e.getEsquinaInfIzq();
		Coordenada esqInfDer = e.getEsquinaInfDer();
		Zona z1 = getZona(esqSupIzq);
		if(z1 != null)
			z1.agregarEntidad(e);
		Zona z2 = getZona(esqSupDer);
		if(z2 != null)
			z2.agregarEntidad(e);
		Zona z3 = getZona(esqInfIzq);
		if(z3 != null)
			z3.agregarEntidad(e);
		Zona z4 = getZona(esqInfDer);
		if(z4 != null)
			z4.agregarEntidad(e);
		
	}
	
	private AbstractSet<Zona> entidadEnZonas(Entidad e) {
		Coordenada esqSupIzq = e.getEsquinaSupIzq();
		Coordenada esqSupDer = e.getEsquinaSupDer();
		Coordenada esqInfIzq = e.getEsquinaInfIzq();
		Coordenada esqInfDer = e.getEsquinaInfDer();
		AbstractSet<Zona> toRet = new HashSet<Zona>();
		Zona z1 = getZona(esqSupIzq);
		if(z1 != null)
			toRet.add(z1);
		Zona z2 = getZona(esqSupDer);
		if(z2 != null)
			toRet.add(z2);
		Zona z3 = getZona(esqInfIzq);
		if(z3 != null)
			toRet.add(z3);
		Zona z4 = getZona(esqInfDer);
		if(z4 != null)
			toRet.add(z4);
		return toRet;
		
	}
	
	//Para jugador, despues volverlo generico.
	//Retorna verdadero si hubo al menos una colision.
	private boolean colisionEnZona(Entidad e, Zona z) {
		boolean colisiono = false;
		for(Entidad ent : z.getListaEntidades()) {
			colisiono = colisiono || e.colisiona(ent);
			if(colisiono) {
				ent.accept(new VisitorJugador((Jugador)e));
			}
		}
		return colisiono;
	}
	
	public boolean detectarColisionesJugador(Entidad e) {
		boolean colisiono = false;
		for(Zona z : entidadEnZonas(e)) {
			colisiono = colisiono || colisionEnZona(e, z);
		}
		return colisiono;
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
