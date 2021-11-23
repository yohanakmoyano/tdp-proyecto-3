package entidades.movibles.jugadores;

import entidades.movibles.EntidadMovible;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import logica.Puntaje;
import patrones.strategy.ControlStrategy;
import patrones.visitor_entidad.VisitorEntidad;
import patrones.visitor_entidad.VisitorJugador;

public  class Jugador extends EntidadMovible {
	//JDC: jugador_456 , AU: jugador_red , PC: Pac_man
	protected ControlStrategy controlStr;
	protected Coordenada posRespawn;
	protected boolean poseeItemD; //esto si tiene un item no mas o tener el item
	//coleccion de power up
	protected static Jugador myInstance;
	protected int cantItemsLevantados;
	

	private Jugador(Coordenada c, int vel, int v, String rutaImg) {
		caminable = true;
		posRespawn = new Coordenada(c.getX(), c.getY());
		ultMovimiento = reposo;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		poseeItemD = false;
		miVisitor = new VisitorJugador(this);
		velocidad = vel;
		vidas = v;
		posicion = c;
		ancho = 19;
		factorMovX = ancho/4;
		alto = 22;
		factorMovY = alto/4;
		cantItemsLevantados=0;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
		controlStr = new ControlStrategy(this); //Por defecto se crea con estrategia presa.
		
	}
	public static Jugador getJugador(Coordenada c, int vel, int v, String rutaImg) {
		if(myInstance == null)
			myInstance = new Jugador(c,vel,v,rutaImg);
		return myInstance;
	}
	
	
	public void afectarPuntaje(int valor) {
		Puntaje.getInstancePuntaje().incrementarEn(valor);
	}
	
public int getCantItemsLevantados() {
		
		//cantItemsLevantados++;
		System.out.println("agarre un item "+cantItemsLevantados);
		return cantItemsLevantados;
	}
	public void setCantItemsLevantados(int n){
		cantItemsLevantados=cantItemsLevantados+1;
	}

	//jugador metodo accionar--> tipo de estado de estrategia cuando suelto delego al strategy
	public ControlStrategy getEstrategia() {
		return controlStr;
	}
	
	/**
	 * Por el momento hace una especie de switch entre las dos estrategias existentes.
	 * Ver como hacer para que esto no dependa de que solo existen dos estrategias.
	 */
	public void cambiarEstrategia() {
		
	}
	
	//falta la coneccion de llamar desde jugaro a itemD
	public boolean tieneItemD() {
		return poseeItemD = true;
	}
	
	//se mueve + en el eje x
	public void moverDerecha() {
		puedoMovermeIzq = true;
		ultMovimiento = ultMovDer;
		actualizarMov = posicion.getX() + (factorMovX);
		posicion.setX(actualizarMov);
		miRep.moverDerecha(factorMovX);
	}
	
	//se mueve - en el eje x
	public void moverIzquierda() {
		puedoMovermeDer = true;
		ultMovimiento = ultMovIzq;
		actualizarMov = posicion.getX() - (factorMovX);
		posicion.setX(actualizarMov);
		miRep.moverIzquierda(factorMovX);
	}
	
	//se mueve - en el eje y
	public void moverArriba() {
		puedoMovermeDown = true;
		ultMovimiento = ultMovUp;
		actualizarMov = posicion.getY() - (factorMovY);
		posicion.setY(actualizarMov);
		miRep.moverArriba(factorMovY);
	}
	
	//se mueve + en el eje y
	public void moverAbajo() {
		puedoMovermeUp = true;
		ultMovimiento = ultMovDown;
		actualizarMov = posicion.getY() + (factorMovY);
		posicion.setY(actualizarMov);
		miRep.moverAbajo(factorMovY);
	}

	public void morir() {
		//Ver como finalizar el juego.
		reUbicar();
	}
	
	public void reUbicar() {
		//System.out.println("Pos anterior a muerte Jugador ("+posicion.getX() + ", " + posicion.getY()+")");
		miRep.eliminar();
		miRep.moverRep(posRespawn.getX(), posRespawn.getY());
		posicion.setX(posRespawn.getX());
		posicion.setY(posRespawn.getY());
		ultMovimiento = reposo;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		//System.out.println("Pos posterior a muerte jugador ("+posicion.getX() + ", " + posicion.getY()+")");
	}
	
	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

	@Override
	public Coordenada nextPosMovDer() {
		return new Coordenada(posicion.getX() + (factorMovX), posicion.getY());
	}

	@Override
	public Coordenada nextPosMovIzq() {
		return new Coordenada(posicion.getX() - (factorMovX), posicion.getY());
	}

	@Override
	public Coordenada nextPosMovUp() {
		return new Coordenada(posicion.getX(), posicion.getY() - (factorMovY));
	}

	@Override
	public Coordenada nextPosMovDown() {
		return new Coordenada(posicion.getX(), posicion.getY() + (factorMovY));
	}
	
	
}
