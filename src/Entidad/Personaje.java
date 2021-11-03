package Entidad;

public abstract class Personaje extends Entidad {
	private int velocidad;
	private int vidas;

	public void cambiarEstado(EstadoPersonaje miEstado) {
		
	}
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int v) {
		vidas=v;
	}
}
