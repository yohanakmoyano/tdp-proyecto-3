package Entidad;

import VisitorEntidad.VisitorEntidad;

public abstract class Entidad {
	protected int ancho;
	protected int alto;
	protected int esquina;

	
	public abstract void accept(VisitorEntidad v);
	
	public RepresentacionGrafica getRepresentacionGrafica() {
	
	}

}
