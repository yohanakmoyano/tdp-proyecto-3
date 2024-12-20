package logica;

import java.util.AbstractSet;
import java.util.HashSet;
import java.awt.Rectangle;
import entidades.Entidad;

public class Zona extends Rectangle {
	
	private static final long serialVersionUID = 1L;
	protected Coordenada posSupIzq;
	protected int ancho;
	protected int alto;
	protected AbstractSet<Entidad> listaEntidades;

	public Zona(int x, int y, int ancho, int alto) {
		super(x, y, ancho, alto);
		posSupIzq = new Coordenada(x, y);
		this.ancho = ancho;
		this.alto = alto;
		listaEntidades = new HashSet<Entidad>();
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
	
	public void agregarEntidad(Entidad e) {
		listaEntidades.add(e);
	}

	public void eliminarEntidad(Entidad e) {
		listaEntidades.remove(e);
	}

}
