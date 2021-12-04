package entidades;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public abstract class Entidad {
	protected boolean alive;
	protected boolean caminable;
	protected VisitorEntidad miVisitor;
	protected int ancho; // mi X
	protected int alto; // mi Y
	protected int esquina;
	protected RepresentacionGrafica miRep;
	protected Coordenada posicion; // se tratará de la esquina superior izquierda.
	// Considerando a la entidad como un cuadrilátero cuyos ángulos interiores son
	// todos rectos.

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

	// Consulta cual es la posicion/coordenada correspondiente a la esquina superior
	// izquierda de la entidad.
	public Coordenada getEsquinaSupIzq() {
		return posicion;
	}

	// Consulta cual es la posicion/coordenada correspondiente a la esquina superior
	// derecha de la entidad.

	public Coordenada getEsquinaSupDer() {
		return new Coordenada(posicion.getX() + ancho, posicion.getY());
	}

	// Consulta cual es la posicion/coordenada correspondiente a la esquina inferior
	// izquierda de la entidad.

	public Coordenada getEsquinaInfIzq() {
		return new Coordenada(posicion.getX(), posicion.getY() + alto);
	}

	// Consulta cual es la posicion/coordenada correspondiente a la esquina inferior derecha de la entidad.

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
