package Logica;

public class Coordenada {

	protected int x; 
	protected int y; 
	
	public Coordenada(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public int getX() {
		return x; 
	}
	
	public int getY() {
		return y;
	}
}
