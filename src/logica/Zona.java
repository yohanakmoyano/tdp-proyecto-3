package logica;

import java.util.ArrayList;
import java.util.List;

import java.awt.Rectangle;
import entidades.Entidad;

public class Zona extends Rectangle {
	protected Coordenada posSupIzq;
	protected int ancho;
	protected int alto;
	protected List<Entidad> listaEntidades; 

	public Zona(int x, int y, int ancho, int alto) {
		posSupIzq = new Coordenada(x, y);
		this.ancho = ancho;
		this.alto = alto;
		
		listaEntidades= new ArrayList<Entidad>(); 
	}
	
	public Coordenada getEsquinaIzqSup() {
		return posSupIzq;
	}
	
	public Coordenada getEsquinaDerSup() {
		return /*esquinaDerSuperior*/null; 
	}
	
	public Coordenada getEsquinaIzqInf() {
		return /*esquinaIzqInferior*/null;
	}
	
	public Coordenada getEsquinaDerInf() {
		return /*esquinaDerInferior*/null;
	}
	
	public List<Entidad> getListaEntidades() {
		return listaEntidades;
	}
	
	public void agregarEntidad(Entidad e) {
		listaEntidades.add(e);
	}
	
	public void eliminarEntidad(Entidad e) {
		listaEntidades.remove(e);
	}	
	
}
