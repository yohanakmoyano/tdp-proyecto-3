package Logica;

import Entidad.Enemigo.Enemigo;

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
