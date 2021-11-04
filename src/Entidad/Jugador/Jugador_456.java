package Entidad.Jugador;

import Entidad.Enemigo.Enemigo;
import Entidad.Item.Item;
import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Jugador_456 extends Jugador{
	
	public Jugador_456(Coordenada c,int vel, int v) {
		velocidad=vel;
		vidas=v;
		posicion=c;
		String rutaBomba=this.getClass().getResource("/Images/jugador_nivel1.png").toString();
		miRep=new RepresentacionGrafica(rutaBomba);
	}
	
	public void colisionConItem(Item i) {
		
	}
	
	public void atacar(Enemigo enemigo) {
		
	}
	
	public void accept(VisitorEntidad v) {
		
	}
}
