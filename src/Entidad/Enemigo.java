package Entidad;

public abstract class Enemigo extends Personaje{
	protected int valor;

	
	public abstract void mover();
	
	public abstract void moverArriba(); 
	
	public abstract void moverAbajo(); 
	
	public abstract void moverIzq(); 
		
	public abstract void moverDer();

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getVelocidad() {
		return velocidad;
	}
	
	public int getvalor() {
		return valor;
	}
	 
	
		
	
}

