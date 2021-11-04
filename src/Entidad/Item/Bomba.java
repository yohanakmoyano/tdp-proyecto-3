package Entidad.Item;

import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Bomba extends ItemD {
	
	public Bomba(int val,Coordenada c) {
		valor=val;
		posicion=c;
	}
	
	public void accept(VisitorEntidad v) {
		
	}
}
