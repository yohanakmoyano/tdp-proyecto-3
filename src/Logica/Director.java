package Logica;

import LevelBuilder.Level1Builder;
import LevelBuilder.Level2Builder;
import LevelBuilder.Level3Builder;
import LevelBuilder.LevelBuilder;

public class Director {
	protected LevelBuilder builder;
	protected int nivel;

	public Director(int n) {
		nivel=n;
		if (nivel==1)
			builder=new Level1Builder();
		if (nivel==2)
			builder=new Level2Builder();
		if (nivel==3)
			builder=new Level3Builder();
	}
	public SalaDeJuegos getSalaDeJuegos() {
		return builder.getResult();
	}
	public void changeLevel(int nvl) {
		nivel=nvl;
		
	}
	public LevelBuilder getNivel(int nvl) {
	LevelBuilder toret=new Level1Builder();
		if (nvl==2)
			toret= new Level2Builder();
		if (nvl==3)
			toret= new Level3Builder();
		return toret;
	}
}
