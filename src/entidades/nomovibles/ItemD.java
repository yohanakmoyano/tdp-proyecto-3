package entidades.nomovibles;

import java.util.Timer;
import java.util.TimerTask;
import entidades.Entidad;
import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEntidad;

/**
 * JDC: Bomba, PC: PotionE, AU: calabaza
 */
public class ItemD extends Entidad {
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
		Coordenada posAct = verificaPosCorrecta(pos);
		String ruta = this.getClass().getResource("/Images/generales/explotion.gif").toString();

		efectoExplosion = new ItemEfecto(valor, posAct, ruta);
		return efectoExplosion;
	}

	public void remover() {
		Timer time = new Timer();
		time.schedule(new TimerTask() {

			public void run() {
				efectoExplosion.eliminar();
			}
		}, 2000);
	}

	public Coordenada verificaPosCorrecta(Coordenada c) {
		int posX = c.getX() + 70;
		int posY = c.getY() + 70;
		int espaioRestX = 0;
		int espaioRestY = 0;
		Coordenada nuevaCord = new Coordenada(c.getX() - 25, c.getY() - 25);

		if (posX >= 499 && posY >= 551) {
			espaioRestX = 499 - c.getX();
			espaioRestY = 551 - c.getY();
			nuevaCord = new Coordenada(c.getX() - (70 - espaioRestX), c.getY() - (70 - espaioRestY));
		} else {
			if (posX >= 499) {
				espaioRestX = 499 - c.getX();
				nuevaCord = new Coordenada(c.getX() - (70 - espaioRestX), c.getY());
			}

			if (posY >= 551) {
				espaioRestY = 551 - c.getY();
				nuevaCord = new Coordenada(c.getX(), c.getY() - (70 - espaioRestY));
			}
		}
		return nuevaCord;

	}

}
