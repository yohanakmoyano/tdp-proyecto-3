package logica;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import entidades.Entidad;
import entidades.movibles.EntidadMovible;
import entidades.movibles.jugadores.Jugador;
import grafica.Gui;
import patrones.visitor_entidad.VisitorJugador;

public class SalaDeJuegos {
	protected Salon miSalon;
	protected Zona matrizZonas[][];
	protected static final int base = 501;
	protected static final int altura = 553;
	protected int cantDivisiones = 4;
	protected List<Entidad> listaEnemigos;
	protected List<Entidad> listaEntidadFija;
	protected List<Entidad> listaJugador;
	protected Gui miGui;
	protected Juego juego;
	protected int cantItems;

	protected Coordenada posAnteriorJug;

	public SalaDeJuegos(Gui g, Juego jueg) {
		int incrementX = base / cantDivisiones;
		int incrementY = altura / cantDivisiones;
		int baseX = 0;
		int alturaY = 0;
		int cantItems = 0;
		int casoEspecialAncho = base - ((cantDivisiones - 1) * incrementX);
		int casoEspecialAlto = altura - ((cantDivisiones - 1) * incrementY);
		matrizZonas = new Zona[cantDivisiones][cantDivisiones];
		for (int i = 0; i < cantDivisiones; i++) {
			for (int j = 0; j < cantDivisiones; j++) {
				if ((i == (cantDivisiones - 1)) || (j == (cantDivisiones - 1))) { // Caso Especial
					if ((i == cantDivisiones - 1) && (j == cantDivisiones - 1)) {
						matrizZonas[i][j] = new Zona(baseX, alturaY, casoEspecialAncho, casoEspecialAlto);
					} else {
						if (i == cantDivisiones - 1) {
							matrizZonas[i][j] = new Zona(baseX, alturaY, casoEspecialAncho, incrementY);
						} else {
							matrizZonas[i][j] = new Zona(baseX, alturaY, incrementX, casoEspecialAlto);
						}
					}
				} else {
					matrizZonas[i][j] = new Zona(baseX, alturaY, incrementX, incrementY);
				}
				baseX = baseX + incrementX + 1;

			}

			baseX = 0;
			alturaY = alturaY + incrementY + 1;

		}
		miSalon = Salon.getInstance();// new Salon(new Coordenada(230, 230));//Cambiar a algo mas automatico.
		listaEnemigos = new ArrayList<Entidad>();
		listaEntidadFija = new ArrayList<Entidad>();
		listaJugador = new ArrayList<Entidad>();
		miGui = g;
		juego = jueg;

	}

	public Gui obtenerGui() {
		return miGui;
	}
	
	public void setCantItems(int cant) {
		cantItems = cant;
	}
	
	public int getCantItems() {
		return cantItems;
	}

	/**
	 * Consulta cual es la zona que contiene al punto PUNTO.
	 * 
	 * @param punto para el cual buscar zona.
	 * @return Zona que contiene a punto.
	 */
	private Zona getZona(Coordenada punto) {
		// System.out.println("--------------------------GetZona-------------------------------------------------------------");
		Coordenada cMatriz = posEnMatriz(punto);
		return matrizZonas[cMatriz.getX()][cMatriz.getY()];
	}

	protected Coordenada posEnMatriz(Coordenada p) {
		int baseZona = base / cantDivisiones;
		int altoZona = altura / cantDivisiones;

		int yout = p.getX() / (baseZona + 1);
		int xout = p.getY() / (altoZona + 1);

		return new Coordenada(xout, yout);
	}

	private void verificarCambioZona(Coordenada oldPos, Coordenada newPos, Entidad e) {
		// System.out.println("--------------------------VerificarCambioZona---------------------------------------------------");
		Zona z = getZona(oldPos);
		Zona ze = getZona(newPos);
		if (z != ze) {
			z.eliminarEntidad(e);
			ze.agregarEntidad(e);
			// System.out.println("--------------------------HuboCambioZona--: "+true);
		}
	}
	
	private boolean posColisiona(Coordenada c) {
		//System.out.println("Pos: "+c.getX()+", "+c.getY());
		Zona z = getZona(c);
		Iterator<Entidad> it = z.getListaEntidades().iterator();
		boolean colisiona = false;
		while(it.hasNext() && !colisiona) {
			Entidad e = it.next();
			colisiona = e.contieneCoordenada(c) && (!e.isCaminable());
		}
		//System.out.println("Pos: "+colisiona);
		return colisiona;
	}

	/**
	 * Consulta si la entidad e, al moverse, cambio las zonas sobre las que está.
	 * @param e entidad por la cual consultar.
	 */
	public void actualizarZonasEntidad(Entidad e) {
		// System.out.println("--------------------------ActualizarZonasEntidad------------------------------------------------");
		Coordenada esqSupIzq = e.getEsquinaSupIzq();
		Coordenada esqSupDer = e.getEsquinaSupDer();
		Coordenada esqInfIzq = e.getEsquinaInfIzq();
		Coordenada esqInfDer = e.getEsquinaInfDer();
		verificarCambioZona(posAnteriorJug, esqSupIzq, e);
		verificarCambioZona(new Coordenada(posAnteriorJug.getX() + e.getAncho(), posAnteriorJug.getY()), esqSupDer, e);
		verificarCambioZona(new Coordenada(posAnteriorJug.getX(), posAnteriorJug.getY() + e.getAlto()), esqInfIzq, e);
		verificarCambioZona(new Coordenada(posAnteriorJug.getX() + e.getAncho(), posAnteriorJug.getY() + e.getAlto()), esqInfDer, e);
	}

	// Modificar autorizaciones
	public boolean autorizarMovArriba(EntidadMovible e) {
		Coordenada newPosSupIzq = e.nextPosMovUp();
		Coordenada newPosSupDer = new Coordenada(newPosSupIzq.getX() + e.getAncho(), newPosSupIzq.getY());
		boolean puedeMoverse = (newPosSupIzq.getY() > 0) && (e.puedoMovermeUp()) && !posColisiona(newPosSupIzq) && !posColisiona(newPosSupDer);
		if (puedeMoverse)
			posAnteriorJug = e.getEsquinaSupIzq();
		// System.out.println("Puede mover => "+puedeMoverse);
		return puedeMoverse;
	}

	public boolean autorizarMovAbajo(EntidadMovible e) {
		Coordenada newPosSupIzq = e.nextPosMovDown();
		Coordenada newPosInfIzq = new Coordenada(newPosSupIzq.getX(), newPosSupIzq.getY() + e.getAlto());
		Coordenada newPosInfDer = new Coordenada(newPosSupIzq.getX() + e.getAncho(), newPosSupIzq.getY() + e.getAlto());
		boolean puedeMoverse = ((newPosSupIzq.getY() + e.getAlto()) < altura) && (e.puedoMovermeDown()) && !posColisiona(newPosInfIzq) && !posColisiona(newPosInfDer);
		if (puedeMoverse)
			posAnteriorJug = e.getEsquinaSupIzq();
		// System.out.println("Puede mover => "+puedeMoverse);
		return puedeMoverse;
	}

	public boolean autorizarMovDerecha(EntidadMovible e) {
		Coordenada newPosSupIzq = e.nextPosMovDer();
		Coordenada newPosSupDer = new Coordenada(newPosSupIzq.getX() + e.getAncho(), newPosSupIzq.getY());
		Coordenada newPosInfDer = new Coordenada(newPosSupIzq.getX() + e.getAncho(), newPosSupIzq.getY() + e.getAlto());
		boolean puedeMoverse = ((newPosSupIzq.getX() + e.getAlto()) < base) && (e.puedoMovermeDer()) && !posColisiona(newPosSupDer) && !posColisiona(newPosInfDer);
		if (puedeMoverse)
			posAnteriorJug = e.getEsquinaSupIzq();
		// System.out.println("Puede mover => "+puedeMoverse);
		return puedeMoverse;
	}

	public boolean autorizarMovIzquierda(EntidadMovible e) {
		Coordenada newPosSupIzq = e.nextPosMovIzq();
		Coordenada newPosInfIzq = new Coordenada(newPosSupIzq.getX(), newPosSupIzq.getY() + e.getAlto());
		boolean puedeMoverse = (newPosSupIzq.getX() > 0) && (e.puedoMovermeIzq()) && !posColisiona(newPosSupIzq) && !posColisiona(newPosInfIzq);
		if (puedeMoverse)
			posAnteriorJug = e.getEsquinaSupIzq();
		// System.out.println("Puede mover => "+puedeMoverse);
		return puedeMoverse;
	}

	private void addEntidadAZonaEn(Coordenada pos, Entidad e) {
		// System.out.println("--------------------------AddEntidadAZonaEn---------------------------------------------------------");
		Zona z = getZona(pos);
		if (z != null) {
			z.agregarEntidad(e);
			// System.out.println("--------------------------AgregoAZona--: "+true);
		}
	}

	public void agregarAZonas(Entidad e) {
		// System.out.println("--------------------------AgregarAZonas----------------------------------------------------------");
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
		// System.out.println("--------------------------AddZonaAConjunto-------------------------------------------------------");
		Zona z = getZona(pos);
		if (z != null)
			col.add(z);
	}

	/**
	 * Consulta las zonas en las que se encuentra la entidad e.
	 * 
	 * @param e entidad por la cual consultar.
	 * @return un conjunto de zonas a las que pertenece la entidad.
	 */
	private AbstractSet<Zona> zonasDeEntidad(Entidad e) {
		// System.out.println("--------------------------EntidadEnZonas-----------------------------------------------------------");
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
		// System.out.println("-------------------------ColisionEnZona------------------------------------------------------------");
		boolean colisiono = false;
		boolean toRet = false;
		for (Entidad ent : z.getListaEntidades()) {
			colisiono = e.colisiona(ent);
			toRet = toRet || colisiono;
			if (colisiono) {
				// System.out.println("--------------------------Hubo Colision --: "+toRet +
				// "("+ent.getEsquinaSupIzq().getX()+", "+ent.getEsquinaSupIzq().getY());
				// System.out.println("--------------------------Entro Visitor--: "+toRet);
				ent.accept(e.getMyVisitor());
				miGui.actualizarPuntaje();
				juego.actualizoVidas();
			} else {/*
					 * EntidadMovible ee = (EntidadMovible)e; ee.resetearMovimientos();
					 */
			}
		}
		return toRet;
	}

	public boolean detectarColisionesJugador(Entidad e) {
		// System.out.println("--------------------------DetectarColsionesJugador-------------------------------------------------");
		boolean colisiono = false;
		boolean toRet = false;
		for (Zona z : zonasDeEntidad(e)) {
			colisiono = colisionEnZona(e, z);
			toRet = toRet || colisiono;
		}
		// System.out.println("--------------------------Hubo Colision--: "+toRet);
		return toRet;
	}

	public List<Entidad> getListaEnemigos() {
		return listaEnemigos;
	}

	public List<Entidad> getListaEntidadFija() {
		return listaEntidadFija;
	}

	public List<Entidad> getListJugador() {
		return listaJugador;
	}

}
