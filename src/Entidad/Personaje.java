package Entidad;

public abstract class Personaje extends Entidad {
	protected int velocidad;
	protected int vidas;

	public void cambiarEstado(EstadoPersonaje miEstado) {
	}
	
	public int getVidas() {
		return vidas;
	}
	
	public void setVidas(int v) {
		vidas=v;
	}
}
