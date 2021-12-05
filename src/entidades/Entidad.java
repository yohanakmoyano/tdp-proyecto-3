package entidades;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public abstract class Entidad {
	protected boolean alive;
	protected boolean caminable;
	protected VisitorEntidad miVisitor;
	protected int ancho;
	protected int alto;
	protected int esquina;
	protected RepresentacionGrafica miRep;
	protected Coordenada posicion; // se tratar� de la esquina superior izquierda.Considerando a la entidad como un cuadril�tero cuyos �ngulos interiores son todos rectos.

	public abstract void accept(VisitorEntidad v);

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAncho(int b) {
		ancho = b;
	}

	public void setAlto(int h) {
		alto = h;
	}

	public boolean isCaminable() {
		return caminable;
	}

	public boolean isAlive() {
		return alive;
	}

	public void isDead() {
		alive = false;
	}

	public void revive() {
		alive = true;
	}

	public Coordenada getEsquinaSupIzq() {
		return posicion;
	}

	public Coordenada getEsquinaSupDer() {
		return new Coordenada(posicion.getX() + ancho, posicion.getY());
	}

	public Coordenada getEsquinaInfIzq() {
		return new Coordenada(posicion.getX(), posicion.getY() + alto);
	}

	public Coordenada getEsquinaInfDer() {
		return new Coordenada(posicion.getX() + ancho, posicion.getY() + alto);
	}

	public RepresentacionGrafica getRepresentacionGrafica() {
		return miRep;
	}

	public Coordenada getPosicion() {
		return posicion;
	}

	public void setCoordenada(Coordenada c) {
		posicion = c;
	}

	public boolean colisiona(Entidad e) {
		return ((this != e) && (miRep.colisiona(e.getRepresentacionGrafica())));
	}

	public boolean contieneCoordenada(Coordenada c) {
		return miRep.contieneCoordenada(c);
	}

	public void eliminar() {
		this.isDead();
		miRep.eliminar();
	}

	public VisitorEntidad getMyVisitor() {
		return miVisitor;
	}
}
