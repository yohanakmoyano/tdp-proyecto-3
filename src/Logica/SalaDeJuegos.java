package Logica;

public class SalaDeJuegos {

	//private boolean laberinto[][];
	protected Zona matrizZonas[][]; 
	protected static final int base=125; 
	protected static final int altura=150; 
	
	public SalaDeJuegos() {
		
		int baseZona=0;
		int alturaZona=0;
		
		matrizZonas=new Zona[4][4];
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				matrizZonas[i][j]=new Zona(new Coordenada(baseZona,alturaZona), new Coordenada(baseZona+base,alturaZona), 
						new Coordenada(baseZona,alturaZona+altura), new Coordenada(baseZona+base,alturaZona+altura));
			
				baseZona=baseZona+base; 
			}
			
			baseZona=0;
			alturaZona=alturaZona+altura; 
			
		}
		
	}
	
}
