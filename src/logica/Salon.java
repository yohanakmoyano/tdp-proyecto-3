package logica;

import entidades.movibles.enemigos.Enemigo;

public class Salon {
	
	protected Coordenada respawn;
	protected static Salon miInstance;

	private Salon(Coordenada r) {
		respawn = r;
	}

	public static Salon getInstance() {
		if (miInstance == null)
			miInstance = new Salon(new Coordenada(241, 241));
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
