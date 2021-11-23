package entidades;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public abstract class Entidad {
	protected boolean caminable;
	protected VisitorEntidad miVisitor;
	protected int ancho; //mi X
	protected int alto; //mi Y
	protected int esquina;
	protected RepresentacionGrafica miRep;
	protected Coordenada posicion; //se tratará de la esquina superior izquierda. Considerando a la entidad como un cuadrilátero cuyos ángulos interiores son todos rectos.
	//protected Puntaje puntajeActual;

	public abstract void accept(VisitorEntidad v);
	
	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	public boolean isCaminable() {
		return caminable;
	}
	
	/**
	 * Consulta cual es la posicion/coordenada correspondiente a la esquina superior izquierda de la entidad.
	 * @return Coordenada de la esquina superior izquierda.
	 */
	public Coordenada getEsquinaSupIzq() {
		return posicion;
	}
	
	/**
	 * Consulta cual es la posicion/coordenada correspondiente a la esquina superior derecha de la entidad.
	 * @return Coordenada de la esquina superior derecha.
	 */
	public Coordenada getEsquinaSupDer() {
		return new Coordenada(posicion.getX()+ancho, posicion.getY());
	}
	
	/**
	 * Consulta cual es la posicion/coordenada correspondiente a la esquina inferior izquierda de la entidad.
	 * @return Coordenada de la esquina inferior izquierda.
	 */
	public Coordenada getEsquinaInfIzq() {
		return new Coordenada(posicion.getX(), posicion.getY()+alto);
	}
	
	/**
	 * Consulta cual es la posicion/coordenada correspondiente a la esquina inferior derecha de la entidad.
	 * @return Coordenada de la esquina inferior derecha.
	 */
	public Coordenada getEsquinaInfDer() {
		return new Coordenada(posicion.getX()+ancho, posicion.getY()+alto);
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
		miRep.eliminar();
	}
	
	public VisitorEntidad getMyVisitor() {
		return miVisitor;
	}
	//agregar acept
}
