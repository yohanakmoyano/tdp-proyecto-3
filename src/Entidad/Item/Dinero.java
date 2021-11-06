package Entidad.Item;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Dinero extends ItemE{

	public Dinero(int val ,Coordenada c) {
		valor=val;
		posicion=c;
		ancho=46;
		alto=23;
		//String rutaDinero=this.getClass().getResource("/Images/dinero_nivel1.png").toString();
		//miRep=new RepresentacionGrafica(rutaDinero);
	}
	public Dinero() {
		
	}
	public void accept(VisitorEntidad v) {
		
	}
}
