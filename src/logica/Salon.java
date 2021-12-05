package logica;

import entidades.movibles.enemigos.Enemigo;
import java.awt.Rectangle;

public class Salon extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int alto;
	protected int ancho;
	protected Coordenada respawn;
	protected static Salon miInstance;

	private Salon(Coordenada r, int ancho, int alto) {
		super(200, 210, ancho, alto);
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
		if ((x >= 210 && x <= 290) && (y > 181 && y < 280))
			return true;
		else
			return false;
	}

	public Coordenada getRespawnPoint() {
		return respawn;
	}

}
