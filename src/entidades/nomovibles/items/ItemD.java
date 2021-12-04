package entidades.nomovibles.items;

import java.util.Timer;
import java.util.TimerTask;

import entidades.Entidad;
import entidades.nomovibles.EntidadNoMovible;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

/**
 * JDC: Bomba, PC: PotionE, AU: calabaza
 */
public class ItemD extends EntidadNoMovible {
	protected ItemEfecto efectoExplosion;
	

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
	
	public Entidad ponerBomba(Coordenada pos) {
		Coordenada newPos = new Coordenada(pos.getX(), pos.getY());
		
		System.out.println("mi posicion de bomba es: "+pos.getX()+"-"+pos.getY());
		
		String ruta = this.getClass().getResource("/Images/JDC/explotion.gif").toString(); 
		efectoExplosion = new ItemEfecto(valor, newPos, ruta);
		return efectoExplosion;
	}
	
	public void remover() {
		Timer time = new Timer();
		time.schedule(new TimerTask() {

			@Override
			public void run() {
				efectoExplosion.eliminar();				
			}}, 2000);
	}
}
