package entidades.nomovibles.items;

import entidades.nomovibles.EntidadNoMovible;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public  class ItemD extends EntidadNoMovible {
	//JDC: Bomba, PC: PotionE, AU: calabaza
	public ItemD(int val, Coordenada c, String rutaImg) {
		caminable = true;
		valor = val;
		posicion = c;
		ancho = 25;
		alto = 25;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}

	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

}
