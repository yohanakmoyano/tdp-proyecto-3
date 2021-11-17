package logica;

public class Puntaje {
	protected int puntaje;
	private static Puntaje myInstance;
	
	private Puntaje() {
		puntaje = 0;
	}
	
	public static Puntaje getInstancePuntaje() {
		if(myInstance == null) {
			myInstance = new Puntaje();
		}
		return myInstance;
	}
	
	public void incrementarEn(int puntos) {
		puntaje += puntos;
		//System.out.println("--------------------------Nuevo Puntaje---------------------------------------"+puntaje);
	}
	
	public int getPuntajeActual() {
		return puntaje;
	}
	
	public void setPuntaje(int p) {
		puntaje = p;
	}
}
