package Entidad.Item;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Bomba extends ItemD {
	
	public Bomba(int val,Coordenada c) {
		valor=val;
		posicion=c;
		String rutaBomba=this.getClass().getResource("/Images/bomba_nivel1.png").toString();
		miRep=new RepresentacionGrafica(rutaBomba);
	}
	
	public void accept(VisitorEntidad v) {
		
	}
}
