package Logica;

import LevelBuilder.LevelBuilder;

public class Director {
	protected LevelBuilder builder;
	protected int nivel;

	public Director() {
		
	}
	public SalaDeJuegos getSalaDeJuegos() {
		return builder.getResult();
	}
	public void changeLevel(int nvl) {
		nivel=nvl;
	}
}
