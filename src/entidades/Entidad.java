package entidades;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public abstract class Entidad {
	protected boolean alive;
	protected VisitorEntidad miVisitor;
	protected int ancho;
	protected int alto;
	protected int valor;
	protected RepresentacionGrafica miRep;
	protected Coordenada posicion; // se tratará de la esquina superior izquierda.Considerando a la entidad como un cuadrilátero cuyos ángulos interiores son todos rectos.

	public int getValor() {
		return valor;
	}

	public void setValor(int val) {
		valor = val;
	}
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

	public boolean colisiona(Entidad e) {
		return ((this != e) && (miRep.colisiona(e.getRepresentacionGrafica())));
	}

	public void eliminar() {
		this.isDead();
		miRep.eliminar();
	}

	public VisitorEntidad getMyVisitor() {
		return miVisitor;
	}
}
