package Entidad;

public abstract class Item {
	protected boolean visible;
	protected int valor;
	
	public abstract void consumido();
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int val) {
		valor = val;
	}

}
