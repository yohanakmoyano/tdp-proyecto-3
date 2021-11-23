package entidades.nomovibles;

import entidades.Entidad;

public abstract class EntidadNoMovible extends Entidad {
	protected int valor;

	public int getValor() {
		return valor;
	}

	public void setValor(int val) {
		valor = val;
	}
}
