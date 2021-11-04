package Entidad.Item;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Galleta extends ItemA {
	
	public Galleta(int val, Coordenada c) {
		valor=val;
		posicion=c;
		String rutaGalleta=this.getClass().getResource("/Images/galleta_nivel1.png").toString();
		miRep=new RepresentacionGrafica(rutaGalleta); 
	}

	public void accept(VisitorEntidad v) {
		
	}
}
