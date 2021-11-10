package LevelBuilder;

import Dominio.FactoryDominio;
import Logica.SalaDeJuegos;

public abstract class LevelBuilder {
	protected SalaDeJuegos sj;
	protected FactoryDominio mifabrica;
	protected String fileName;

	public void reset() {

	}
	
	public abstract void buildEnemigos();

	public abstract void buildItems();

	public abstract void buildPlayer();

	public SalaDeJuegos getResult() {
		return sj;
	}

}
