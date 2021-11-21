package patrones.level_builder;


import logica.SalaDeJuegos;

public class Director {
	protected LevelBuilder builder;
	protected int nivel;
	//pasar la fabrica directamentamente o alguna forma de idenficar como atributo o contructor
	
	public Director(int n, SalaDeJuegos sj,int j) {
		nivel=n;
		
		if (nivel==1) 
			builder=new Level1Builder(sj,j);
		
		if (nivel==2)
			builder=new Level2Builder(sj,j);
		
		if (nivel==3)
			builder=new Level3Builder(sj,j);	
	}
	
	
	public void changeLevel(int nvl) {
		nivel=nvl;
		
	}

}
