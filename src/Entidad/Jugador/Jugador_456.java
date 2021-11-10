package Entidad.Jugador;

import Entidad.Enemigo.Enemigo;
import Entidad.Item.Item;
import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import Strategy.StrategyJugador;
import VisitorEntidad.VisitorEntidad;

public class Jugador_456 extends Jugador {
	protected StrategyJugador stg;

	public Jugador_456(Coordenada c, int vel, int v, String rutaImg) {
		velocidad = vel;
		vidas = v;
		posicion = c;
		// String
		// rutaJugador=this.getClass().getResource("/Images/jugador_nivel1.png").toString();
		miRep = new RepresentacionGrafica(rutaImg);
	}

	public Jugador_456() {

	}

	public void colisionConItem(Item i) {

	}

	public void atacar(Enemigo enemigo) {

	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

	public void morir() {
		// SalaDeJuegos.getListaEliminar().add(this);
		// SalaDeJuegos.getJuego().finDeJuego();
	}
}
