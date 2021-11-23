package logica;

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

	public Coordenada getRespawnPoint() {
		return respawn;
	}

}
