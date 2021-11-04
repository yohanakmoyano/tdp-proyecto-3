package Entidad.Item;

import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Dinero extends ItemE{

	public Dinero(int val ,Coordenada c) {
		valor=val;
		posicion=c;
	}
	
	public void accept(VisitorEntidad v) {
		
	}
}
