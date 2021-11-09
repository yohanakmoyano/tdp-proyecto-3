package Entidad.Item;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Cuchillo extends ItemB {
	
	public Cuchillo(int val, Coordenada c) {
		valor=val;
		posicion=c;
		ancho=40;
		alto=58;
		//String rutaCuchillo=this.getClass().getResource("/Images/cuchillo_nivel1.png").toString();
		//miRep=new RepresentacionGrafica(rutaCuchillo);
	}
	public Cuchillo() {
	
	}
	
	public void accept(VisitorEntidad v) {
		
	}
	
	
}
