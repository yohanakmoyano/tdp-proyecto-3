package Entidad;

import Grafica.RepresentacionGrafica;
import VisitorEntidad.VisitorEntidad;

public abstract class Entidad {
	protected int ancho;
	protected int alto;
	protected int esquina;
	protected RepresentacionGrafica miRep;

	public abstract void accept(VisitorEntidad v);
	
	public RepresentacionGrafica getRepresentacionGrafica() {
		return miRep;
	}

}
