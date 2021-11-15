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
	
	protected Coordenada posAnteriorJug;
	
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
		System.out.println("--------------------------GetZona-------------------------------------------------------------");
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

	private void verificarCambioZona(Coordenada oldPos, Coordenada newPos, Entidad e) {
		System.out.println("--------------------------VerificarCambioZona---------------------------------------------------");
		Zona z = getZona(oldPos);
		Zona ze = getZona(newPos);
		if(z != ze) {
			z.eliminarEntidad(e);
			ze.agregarEntidad(e);
			System.out.println("--------------------------HuboCambioZona--: "+true);
		}
	}
	
	/**
	 * Consulta si la entidad e, al moverse, cambio las zonas sobre las que está.
	 * @param e entidad por la cual consultar.
	 */
	public void actualizarZonasEntidad(Entidad e) {
		System.out.println("--------------------------ActualizarZonasEntidad------------------------------------------------");
		Coordenada esqSupIzq = e.getEsquinaSupIzq();
		Coordenada esqSupDer = e.getEsquinaSupDer();
		Coordenada esqInfIzq = e.getEsquinaInfIzq();
		Coordenada esqInfDer = e.getEsquinaInfDer();
		verificarCambioZona(posAnteriorJug, esqSupIzq, e);
		verificarCambioZona(new Coordenada(posAnteriorJug.getX() + e.getAncho(), posAnteriorJug.getY()), esqSupDer, e);
		verificarCambioZona(new Coordenada(posAnteriorJug.getX(), posAnteriorJug.getY() + e.getAlto()), esqInfIzq, e);
		verificarCambioZona(new Coordenada(posAnteriorJug.getX() + e.getAncho(), posAnteriorJug.getY() + e.getAlto()), esqInfDer, e);
	}
	
	//Modificar autorizaciones
	public boolean autorizarMovArriba(EntidadMovible e) {
		boolean puedeMoverse = ((e.getEsquinaSupIzq().getY() - (e.getAlto()/2)) > 0);
		if(puedeMoverse)
			posAnteriorJug = e.getEsquinaSupIzq();
		System.out.println("Puede mover => "+puedeMoverse);
		return puedeMoverse;
	}
	
	public boolean autorizarMovAbajo(EntidadMovible e) {
		boolean puedeMoverse = ((e.getEsquinaSupIzq().getY() + (e.getAlto()/2)) < altura);
		if(puedeMoverse)
			posAnteriorJug = e.getEsquinaSupIzq();
		System.out.println("Puede mover => "+puedeMoverse);
		return puedeMoverse;
	}
	
	public boolean autorizarMovDerecha(EntidadMovible e) {
		boolean puedeMoverse = ((e.getEsquinaSupIzq().getX() + (e.getAncho()/2)) < base);
		if(puedeMoverse)
			posAnteriorJug = e.getEsquinaSupIzq();
		System.out.println("Puede mover => "+puedeMoverse);
		return puedeMoverse;
	}
	
	public boolean autorizarMovIzquierda(EntidadMovible e) {
		boolean puedeMoverse = ((e.getEsquinaSupIzq().getX() - (e.getAncho()/2)) > 0);
		if(puedeMoverse)
			posAnteriorJug = e.getEsquinaSupIzq();
		System.out.println("Puede mover => "+puedeMoverse);
		return puedeMoverse;
	}
	
	private void addEntidadAZonaEn(Coordenada pos, Entidad e) {
	System.out.println("--------------------------AddEntidadAZonaEn---------------------------------------------------------");
		Zona z = getZona(pos);
		if(z != null) {
			z.agregarEntidad(e);
			System.out.println("--------------------------AgregoAZona--: "+true);
		}
	}
	
	public void agregarAZonas(Entidad e) {
		System.out.println("--------------------------AgregarAZonas----------------------------------------------------------");
		Coordenada esqSupIzq = e.getEsquinaSupIzq();
		Coordenada esqSupDer = e.getEsquinaSupDer();
		Coordenada esqInfIzq = e.getEsquinaInfIzq();
		Coordenada esqInfDer = e.getEsquinaInfDer();
		addEntidadAZonaEn(esqSupIzq, e);
		addEntidadAZonaEn(esqSupDer, e);
		addEntidadAZonaEn(esqInfIzq, e);
		addEntidadAZonaEn(esqInfDer, e);
		
	}
	
	private void addZonaAConjunto(AbstractSet<Zona> col, Coordenada pos) {
		System.out.println("--------------------------AddZonaAConjunto-------------------------------------------------------");
		Zona z = getZona(pos);
		if(z != null)
			col.add(z);
	}
	
	/**
	 * Consulta las zonas en las que se encuentra la entidad e.
	 * @param e entidad por la cual consultar.
	 * @return un conjunto de zonas a las que pertenece la entidad.
	 */
	private AbstractSet<Zona> entidadEnZonas(Entidad e) {
		System.out.println("--------------------------EntidadEnZonas-----------------------------------------------------------");
		Coordenada esqSupIzq = e.getEsquinaSupIzq();
		Coordenada esqSupDer = e.getEsquinaSupDer();
		Coordenada esqInfIzq = e.getEsquinaInfIzq();
		Coordenada esqInfDer = e.getEsquinaInfDer();
		AbstractSet<Zona> toRet = new HashSet<Zona>();
		addZonaAConjunto(toRet, esqSupIzq);
		addZonaAConjunto(toRet, esqSupDer);
		addZonaAConjunto(toRet, esqInfIzq);
		addZonaAConjunto(toRet, esqInfDer);
		return toRet;
		
	}
	
	private boolean colisionEnZona(Entidad e, Zona z) {
		System.out.println("-------------------------ColisionEnZona------------------------------------------------------------");
		boolean colisiono = false;
		boolean toRet = false;
		for(Entidad ent : z.getListaEntidades()) {
			colisiono = e.colisiona(ent);
			toRet = toRet || colisiono;
			if(colisiono) {
				System.out.println("--------------------------Hubo Colision --: "+toRet + "("+ent.getEsquinaSupIzq().getX()+", "+ent.getEsquinaSupIzq().getY());
				System.out.println("--------------------------Entro Visitor--: "+toRet);
				ent.accept(e.getMyVisitor());
			}
		}
		return toRet;
	}
	
	public boolean detectarColisionesJugador(Entidad e) {
		System.out.println("--------------------------DetectarColsionesJugador-------------------------------------------------");
		boolean colisiono = false;
		boolean toRet = false;
		for(Zona z : entidadEnZonas(e)) {
			colisiono = colisionEnZona(e, z);
			toRet = toRet || colisiono;
		}
		System.out.println("--------------------------Hubo Colision--: "+toRet);
		return toRet;
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
