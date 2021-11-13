package entidades.movibles.jugadores;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.strategy.StrategyJugador;
import patrones.visitor_entidad.VisitorEntidad;

public class Jugador_456 extends Jugador {
	protected static Jugador_456 myInstance;
	protected StrategyJugador stg;

	// TODO
	/**Dado que tira error al momento de crear los niveles, por ahora dejaré este constructor público.
	//Evitando así posibles errores al modificar esas lineas.
	//Una vez solucionado eso, pasar el constructor a privado.**/
	public Jugador_456(Coordenada c, int vel, int v, String rutaImg) {
		velocidad = vel;
		vidas = v;
		posicion = c;
		ancho =40;
		alto =40;
		miRep = new RepresentacionGrafica(rutaImg);
	}
	
	private Jugador_456() {
		// TODO acá llamar al constructor Jugador_456(Coordenada c, int vel, int v, String rutaImg) con
		//		los parámetros adecuados.
	}
	
	public static Jugador getJugador() {
		if(myInstance == null)
			myInstance = new Jugador_456();
		return myInstance;
	}
	
	public void moverDerecha() {
		// TODO Auto-generated method stub
		
	}
	
	public void moverIzquierda() {
		// TODO Auto-generated method stub
		
	}
	
	public void moverArriba() {
		// TODO Auto-generated method stub
		
	}
	
	public void moverAbajo() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean perderVida() {
		// TODO Auto-generated method stub
		return false;
	}

	public void morir() {
		// SalaDeJuegos.getListaEliminar().add(this);
		// SalaDeJuegos.getJuego().finDeJuego();
	}

	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

}
