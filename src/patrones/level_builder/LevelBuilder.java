package patrones.level_builder;

import java.net.URL;

import logica.SalaDeJuegos;

public abstract class LevelBuilder {
	protected SalaDeJuegos nivel;
	protected String fileName;
	protected URL musica;
	
	public void reset() {

	}
	public URL getMusica(){
		return musica;
	}
	
	/*public abstract void buildEnemigos();

	public abstract void buildItems();

	public abstract void buildPlayer();*/


}
