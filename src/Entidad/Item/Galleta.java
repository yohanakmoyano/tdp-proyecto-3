package Entidad.Item;

import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Galleta extends ItemA {
	
	public Galleta(int val, Coordenada c) {
		valor=val;
		posicion=c;
	}

	public void accept(VisitorEntidad v) {
		
	}
}
