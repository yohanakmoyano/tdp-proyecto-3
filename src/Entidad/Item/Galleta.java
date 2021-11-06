package Entidad.Item;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Galleta extends ItemA {
	
	public Galleta(int val, Coordenada c) {
		valor=val;
		posicion=c;
		ancho=22;
		alto=23;
		//String rutaGalleta=this.getClass().getResource("/Images/galleta_nivel1.png").toString();
	//	miRep=new RepresentacionGrafica(rutaGalleta); 
	}
	public Galleta() {
		
	}
	public void accept(VisitorEntidad v) {
		
	}
}
