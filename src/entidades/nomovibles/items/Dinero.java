package entidades.nomovibles.items;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class Dinero extends ItemE {

	public Dinero(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho =16;// 46;
		alto = 10;//23;
		// String
		// rutaDinero=this.getClass().getResource("/Images/dinero_nivel1.png").toString();
		miRep = new RepresentacionGrafica(rutaImg);
	}

	public Dinero() {

	}

	public void accept(VisitorEntidad v) {

	}

}
