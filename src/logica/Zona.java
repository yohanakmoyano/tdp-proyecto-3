package logica;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.awt.Rectangle;
import entidades.Entidad;

@SuppressWarnings("serial")
public class Zona extends Rectangle {
	protected Coordenada posSupIzq;
	protected int ancho;
	protected int alto;
	protected AbstractSet<Entidad> listaEntidades;

	public Zona(int x, int y, int ancho, int alto) {
		super(x, y, ancho, alto);
		posSupIzq = new Coordenada(x, y);
		this.ancho = ancho;
		this.alto = alto;
		listaEntidades = new HashSet<Entidad>(); // Me aseguro de no tener entidades repetidas dentro de la lista.
	}

	public Coordenada getEsquinaSupIzq() {
		return posSupIzq;
	}

	public Coordenada getEsquinaSupDer() {
		return new Coordenada(posSupIzq.getX() + ancho, posSupIzq.getY());
	}

	public Coordenada getEsquinaInfIzq() {
		return new Coordenada(posSupIzq.getX(), posSupIzq.getY() + alto);
	}

	public Coordenada getEsquinaInfDer() {
		return new Coordenada(posSupIzq.getX() + ancho, posSupIzq.getY() + alto);
	}

	public AbstractSet<Entidad> getListaEntidades() {
		return listaEntidades;
	}
	
	public List<Entidad> getEntColisionadas(Entidad e) {
		List<Entidad> listaEntCol = new ArrayList<Entidad>();
		
		for(Entidad entidad : listaEntidades) {
			if(entidad.colisiona(e))	
				listaEntCol.add(entidad);
		}
		return listaEntCol;
	}

	public void agregarEntidad(Entidad e) {
		listaEntidades.add(e);
	}

	public void eliminarEntidad(Entidad e) {
		listaEntidades.remove(e);
	}

}
