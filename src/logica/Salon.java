package logica;

import entidades.movibles.enemigos.Enemigo;

public class Salon {
	private Zona zonaSalon; 
	
	public Salon() {
		
	}
	
	public Enemigo regenerarEnemigo(Enemigo enem) {
		return enem;
	}
	
	public void setZonaSalon(Zona z) {
		zonaSalon=z;
	}
	
	public Zona getZonaSalon() {
		return zonaSalon; 
	}
	
}
