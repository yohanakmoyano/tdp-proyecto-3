package LevelBuilder;

import Logica.SalaDeJuegos;

public abstract class LevelBuilder {
protected SalaDeJuegos sj;

public abstract void reset();
public abstract void buildEnemigos();
public abstract void buildItems();
public abstract void buildPlayer();
public  SalaDeJuegos getResult() {
	return null;
}
}
