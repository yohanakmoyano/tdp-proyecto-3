package Entidad.Item;

import Entidad.Entidad;

public abstract class Item extends Entidad {
	protected boolean visible;
	protected int valor;
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int val) {
		valor = val;
	}

}
