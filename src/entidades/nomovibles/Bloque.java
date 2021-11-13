package entidades.nomovibles;

import entidades.Entidad;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class Bloque extends Entidad {
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

}