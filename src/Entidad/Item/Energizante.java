package Entidad.Item;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Energizante extends ItemC {

	public Energizante(int val,Coordenada c) {
		valor=val;
		posicion=c;
		ancho=40;
		alto=58;
		//String rutaEnergizante=this.getClass().getResource("/Images/energizante_nivel1.png").toString();
		//miRep=new RepresentacionGrafica(rutaEnergizante);
	}
	public Energizante() {
		
	}
	public void accept(VisitorEntidad v) {
		
	}
}
