package Entidad;

public abstract class Enemigo extends Personaje{
	protected int valor;

	
	public abstract void mover();
	
	protected abstract void moverArriba(); 
	
	protected abstract void moverAbajo(); 
	
	protected abstract void moverIzq(); 
		
	protected abstract void moverDer();

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

