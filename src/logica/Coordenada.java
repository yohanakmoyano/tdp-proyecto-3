package logica;

public class Coordenada {
	protected int x; 
	protected int y; 
	
	protected int xAnterior;
	protected int yAnterior;
	
	public Coordenada(int x,int y) {
		xAnterior = x;
		yAnterior = y;
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		xAnterior = this.x;
		this.x = x;
	}
	
	public void setY(int y) {
		yAnterior = this.y;
		this.y = y;
	}
	
	public void comeBackX() {
		x = xAnterior;
	}

	public void comeBackY() {
		y = yAnterior;
	}
	
	public int distanciaX(int x2) {
		return Math.abs(x-x2);
	}

	public int distanciaY(int y2) {
		return Math.abs(y-y2);
	}
	
	public boolean isValid(int maxX, int maxY) {
		return (((x>=0) && (x<=maxX)) && ((y>=0) && (y<=maxY)));
	}
	
	public int getX() {
		return x; 
	}
	
	public int getY() {
		return y;
	}
}
