package Entidad.Item;

import Entidad.Entidad;
import Grafica.RepresentacionGrafica;
import Logica.Coordenada;
import VisitorEntidad.VisitorEntidad;

public class Bloque extends Entidad{
	public Bloque(Coordenada c, String rutaImg,int anc,int alt) {
		posicion = c;
		ancho = anc;//10;
		alto = alt;//60;
		miRep = new RepresentacionGrafica(rutaImg);
	}

	@Override
	public void accept(VisitorEntidad v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAncho() {
		return ancho;
	}

	@Override
	public int getAlto() {
		return alto;
	}

}
