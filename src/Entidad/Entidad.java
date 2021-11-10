package Entidad;

import javax.swing.JLabel;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public abstract class Entidad {
	protected int ancho;
	protected int alto;
	protected int esquina;
	protected RepresentacionGrafica miRep;
	protected Coordenada posicion; 
	protected JLabel dibujo;

	public abstract void accept(VisitorEntidad v);
	
	public abstract int getAncho();
	
	public abstract int getAlto();
	
	public RepresentacionGrafica getRepresentacionGrafica() {
		return miRep;
	}
	
	public Coordenada getPosicion() {
		return posicion;
	}
	public JLabel getDibujo() {
		return dibujo;
	}
	
	
	
}
