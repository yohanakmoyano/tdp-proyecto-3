package patrones.level_builder;

import dominio.FactoryDominio;
import logica.SalaDeJuegos;

public abstract class LevelBuilder {
	protected SalaDeJuegos nivel;
	
	protected FactoryDominio mifabrica;
	protected String fileName;

	public void reset() {

	}
	
	public abstract void buildEnemigos();

	public abstract void buildItems();

	public abstract void buildPlayer();


}
