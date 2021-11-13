package entidades;

import javax.swing.JLabel;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import logica.Puntaje;
import patrones.visitor_entidad.VisitorEntidad;

public abstract class Entidad {
	protected int ancho;
	protected int alto;
	protected int esquina;
	protected RepresentacionGrafica miRep;
	protected Coordenada posicion; 
	protected JLabel dibujo;
	protected Puntaje puntajeActual;

	public abstract void accept(VisitorEntidad v);

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
		
	public RepresentacionGrafica getRepresentacionGrafica() {
		return miRep;
	}
	
	public Coordenada getPosicion() {
		return posicion;
	}
	public JLabel getDibujo() {
		return dibujo;
	}
	
	public void afectarPuntaje(int valor) {
		puntajeActual.incrementarEn(valor);
	}
	
}
