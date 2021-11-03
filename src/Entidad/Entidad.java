package Entidad;

import com.sun.org.apache.bcel.internal.generic.Visitor;

public abstract class Entidad {
	protected int ancho;
	protected int alto;
	protected int esquina;

	
	public abstract void accept(Visitor v) {
		
	}
	
	public RepresentacionGrafica getRepresentacionGrafica() {
	
	}

}
