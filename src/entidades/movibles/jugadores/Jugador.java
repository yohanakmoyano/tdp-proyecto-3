package entidades.movibles.jugadores;

import entidades.movibles.EntidadMovible;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import logica.Juego;
import patrones.strategy.ControlStrategy;
import patrones.visitor_entidad.VisitorEntidad;
import patrones.visitor_entidad.VisitorJugador;

public class Jugador extends EntidadMovible {
	// JDC: jugador_456 , AU: jugador_red , PC: Pac_man
	protected ControlStrategy controlStr;
	protected Coordenada posRespawn;
	protected boolean poseeItemD;
	protected static Jugador myInstance;
	protected int cantItemsLevantados;
	protected Juego juego;
	protected boolean transformacion;
	private Jugador(Coordenada c, String rutaImg, Juego jueg) {
		alive = true;
		caminable = true;
		posRespawn = new Coordenada(c.getX(), c.getY());
		ultMovimiento = REPOSO;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		poseeItemD = false;
		miVisitor = new VisitorJugador(this);
		juego = jueg;
		velocidad = 1;
		vidas = 3;
		posicion = c;
		ancho = 19;
		factorMovX = ancho / 4;
		alto = 22;
		factorMovY = alto / 4;
		cantItemsLevantados = 0;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
		controlStr = new ControlStrategy(this); // Por defecto se crea con estrategia presa.
		transformacion=false;

	}

	public static Jugador getJugador(Coordenada c, String rutaImg, Juego jueg) {
		if (myInstance == null)
			myInstance = new Jugador(c, rutaImg, jueg);
		return myInstance;
	}

	public void afectarPuntaje(int valor) {
		juego.setPuntaje(valor);
	}
	public void resetNivel() {
		cantItemsLevantados=0;
	}
	
	public void setCantItemsLevantados() {
		cantItemsLevantados = cantItemsLevantados + 1;
		juego.chequearGameOver(cantItemsLevantados);
	}

	public ControlStrategy getEstrategia() {
		return controlStr;
	}

	public boolean tieneItemD() {
		return poseeItemD = true;
	}

	public void moverDerecha() {
		puedoMovermeIzq = true;
		ultMovimiento = ULT_MOV_DER;
		actualizarMov = posicion.getX() + (factorMovX*velocidad);
		posicion.setX(actualizarMov);
		miRep.moverDerecha(factorMovX);
	}

	public void moverIzquierda() {
		puedoMovermeDer = true;
		ultMovimiento = ULT_MOV_IZQ;
		actualizarMov = posicion.getX() - (factorMovX*velocidad);
		posicion.setX(actualizarMov);
		miRep.moverIzquierda(factorMovX);
	}

	public void moverArriba() {
		puedoMovermeDown = true;
		ultMovimiento = ULT_MOV_UP;
		actualizarMov = posicion.getY() - (factorMovY*velocidad);
		posicion.setY(actualizarMov);
		miRep.moverArriba(factorMovY);
	}

	public void moverAbajo() {
		puedoMovermeUp = true;
		ultMovimiento = ULT_MOV_DOWN;
		actualizarMov = posicion.getY() + (factorMovY*velocidad);
		posicion.setY(actualizarMov);
		miRep.moverAbajo(factorMovY);
	}

	public void morir() {
		miRep.eliminar();
		this.isDead();
	}
	public void cambiarCoordenada(Coordenada p) {
		posRespawn=p;
	}
	public void reUbicar() {
		miRep.eliminar();
		miRep.moverRep(posRespawn.getX(), posRespawn.getY());
		posicion.setX(posRespawn.getX());
		posicion.setY(posRespawn.getY());
		ultMovimiento = REPOSO;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
	}
	public void setTransformacion(boolean t){
		transformacion=t;
		if (transformacion)
		juego.TransformarJugador();
	}
	public boolean getTranformacion() {
		return transformacion;
	}
	public void cambiarImagen(String r, int x, int y, int ancho, int alto) {
		this.getRepresentacionGrafica().eliminar();
		//RepresentacionGrafica mir=this.getRepresentacionGrafica() ;
		miRep=new RepresentacionGrafica(r,x,y,ancho,alto);
		//this.getRepresentacionGrafica().setDibujo(r,x,y,ancho,alto);
	}
	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

	@Override
	public Coordenada nextPosMovDer() {
		return new Coordenada(posicion.getX() + (factorMovX*velocidad), posicion.getY());
	}

	@Override
	public Coordenada nextPosMovIzq() {
		return new Coordenada(posicion.getX() - (factorMovX*velocidad), posicion.getY());
	}

	@Override
	public Coordenada nextPosMovUp() {
		return new Coordenada(posicion.getX(), posicion.getY() - (factorMovY*velocidad));
	}

	@Override
	public Coordenada nextPosMovDown() {
		return new Coordenada(posicion.getX(), posicion.getY() + (factorMovY*velocidad));
	}

}
