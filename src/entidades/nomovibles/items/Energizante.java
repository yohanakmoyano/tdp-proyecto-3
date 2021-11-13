package entidades.nomovibles.items;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class Energizante extends ItemC {

	public Energizante(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho = 16;//40;
		alto = 10;//58;
		// String
		// rutaEnergizante=this.getClass().getResource("/Images/energizante_nivel1.png").toString();
		miRep = new RepresentacionGrafica(rutaImg);
	}

	public Energizante() {

	}

	public void accept(VisitorEntidad v) {

	}
	
}
