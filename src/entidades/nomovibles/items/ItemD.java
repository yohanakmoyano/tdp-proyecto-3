package entidades.nomovibles.items;

import java.util.Timer;
import java.util.TimerTask;

import entidades.nomovibles.EntidadNoMovible;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

public class ItemD extends EntidadNoMovible {
	// JDC: Bomba, PC: PotionE, AU: calabaza

	public ItemD(int val, Coordenada c, String rutaImg) {
		alive = true;
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
	
	public void ponerBomba(Coordenada pos) {
		miRep.moverRep(pos.getX(),pos.getY());
		remover();
	}
	
	public void remover() {
		Timer time = new Timer();
		//this.setAlto(100);
		//this.setAncho(100);
		//miRep = new RepresentacionGrafica(rutaUrl, getPosicion().getX(), getPosicion().getY(), ancho, alto);
		
		time.schedule(new TimerTask() {

			@Override
			public void run() {
				miRep.eliminar();				
			}}, 3000);
	}
}
