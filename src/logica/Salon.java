package logica;

import entidades.movibles.enemigos.Enemigo;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Salon extends Rectangle {
	protected int alto;
	protected int ancho;
	protected Coordenada respawn;
	protected static Salon miInstance;

	private Salon(Coordenada r, int ancho, int alto) {
		super(241, 201, ancho, alto);
		respawn = r;
		this.alto = alto;
		this.ancho = ancho;
	}

	public static Salon getInstance() {
		if (miInstance == null)
			miInstance = new Salon(new Coordenada(241, 241), 100, 80);
		return miInstance;
	}

	public boolean estaDentro(Enemigo e) {
		int x = e.getPosicion().getX();
		int y = e.getPosicion().getY();
		return this.contains(x, y);
	}
	
	public Coordenada getRespawnPoint() {
		return respawn;
	}

}
