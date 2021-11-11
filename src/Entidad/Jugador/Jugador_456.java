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
		ancho =40;
		alto =40;
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
