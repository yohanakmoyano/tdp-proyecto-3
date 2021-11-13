package patrones.level_builder;

import logica.SalaDeJuegos;

public class Director {
	protected LevelBuilder builder;
	protected int nivel;

	public Director(int n, SalaDeJuegos sj) {
		nivel=n;
		if (nivel==1)
			builder=new Level1Builder(sj);
		if (nivel==2)
			builder=new Level2Builder(sj);
		if (nivel==3)
			builder=new Level3Builder(sj);
		
	}
	
	public void changeLevel(int nvl) {
		nivel=nvl;
		
	}

}
