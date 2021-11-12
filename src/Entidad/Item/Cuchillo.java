package Entidad.Item;

import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Cuchillo extends ItemB {

	public Cuchillo(int val, Coordenada c, String rutaImg) {
		valor = val;
		posicion = c;
		ancho =16;// 40;
		alto =10;// 58;
		// String
		// rutaCuchillo=this.getClass().getResource("/Images/cuchillo_nivel1.png").toString();
		miRep = new RepresentacionGrafica(rutaImg);
	}

	public Cuchillo() {

	}

	public void accept(VisitorEntidad v) {

	}
	
	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

}
