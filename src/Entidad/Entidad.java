package Entidad;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public abstract class Entidad {
	protected int ancho;
	protected int alto;
	protected int esquina;
	protected RepresentacionGrafica miRep;
	protected Coordenada posicion; 

	public abstract void accept(VisitorEntidad v);
	
	public RepresentacionGrafica getRepresentacionGrafica() {
		return miRep;
	}
	
	public Coordenada getPosicion() {
		return posicion;
	}

}
