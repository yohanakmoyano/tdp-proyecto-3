package Entidad.Item;

import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Energizante extends ItemC {

	public Energizante(int val,Coordenada c) {
		valor=val;
		posicion=c;
	}
	
	public void accept(VisitorEntidad v) {
		
	}
}
