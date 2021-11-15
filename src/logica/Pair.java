package logica;

public class Pair<X, Y> {
	protected X x;
	protected Y y;
	
	public Pair(X xx, Y yy) {
		x = xx;
		y = yy;
	}
	
	public X getX() {
		return x;
	}
	
	public Y getY() {
		return y;
	}
	
	public void setX(X xx) {
		x = xx;
	}
	
	public void setY(Y yy) {
		y = yy;
	}
}
