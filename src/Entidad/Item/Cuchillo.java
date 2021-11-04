package Entidad.Item;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Cuchillo extends ItemB {
	
	public Cuchillo(int val, Coordenada c) {
		valor=val;
		posicion=c;
		String rutaCuchillo=this.getClass().getResource("/Images/cuchillo_nivel1.png").toString();
		miRep=new RepresentacionGrafica(rutaCuchillo);
	}
	
	public void accept(VisitorEntidad v) {
		
	}
}
