package entidades.movibles.enemigos;

import grafica.RepresentacionGrafica;
import logica.Coordenada;
import patrones.visitor_entidad.VisitorEnemigo;
import patrones.visitor_entidad.VisitorEntidad;

public class EnemigoB extends Enemigo {
	//JDC: cuadrado, PC: Inky , AU: blue
	
	
	public EnemigoB(Coordenada c, String rutaImg) {
		alive = true;
		caminable = true;
		ultMovimiento = reposo;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		miVisitor = new VisitorEnemigo(this);
		posicion = c;
		ancho = 20;
		factorMovX = ancho/4;
		alto =20;
		factorMovY = alto/4;
		miRep = new RepresentacionGrafica(rutaImg, c.getX(), c.getY(), ancho, alto);
	}
	
	@Override
	public void moverArriba() {
		puedoMovermeDown = true;
		ultMovimiento = ultMovUp;
		actualizarMov = posicion.getY() - (factorMovY);
		posicion.setY(actualizarMov);
		miRep.moverArriba(factorMovY);
	}

	@Override
	public void moverAbajo() {
		puedoMovermeUp = true;
		ultMovimiento = ultMovDown;
		actualizarMov = posicion.getY() + (factorMovY);
		posicion.setY(actualizarMov);
		miRep.moverAbajo(factorMovY);
	}

	@Override
	public void moverIzquierda() {
		puedoMovermeDer = true;
		ultMovimiento = ultMovIzq;
		actualizarMov = posicion.getX() - (factorMovX);
		posicion.setX(actualizarMov);
		miRep.moverIzquierda(factorMovX);
	}

	@Override
	public void moverDerecha() {
		puedoMovermeIzq = true;
		ultMovimiento = ultMovDer;
		actualizarMov = posicion.getX() + (factorMovX);
		posicion.setX(actualizarMov);
		miRep.moverDerecha(factorMovX);
	}
	
	@Override
	public void accept(VisitorEntidad v) {
		v.visit(this);
	}

	@Override
	public void morir() {
		this.isDead();
		System.out.println("Pos anterior a muerte Boss ("+posicion.getX() + ", " + posicion.getY()+")");
		miRep.moverRep(miSalon.getRespawnPoint().getX(), miSalon.getRespawnPoint().getY());
		posicion.setX(miSalon.getRespawnPoint().getX());
		posicion.setY(miSalon.getRespawnPoint().getY());
		ultMovimiento = reposo;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown = true;
		System.out.println("Pos posterior a muerte Boss ("+posicion.getX() + ", " + posicion.getY()+")");
		this.revive();
	}

	@Override
	public Coordenada nextPosMovDer() {
		return new Coordenada(posicion.getX() + (factorMovX), posicion.getY());
	}

	@Override
	public Coordenada nextPosMovIzq() {
		return new Coordenada(posicion.getX() - (factorMovX), posicion.getY());
	}

	@Override
	public Coordenada nextPosMovUp() {
		return new Coordenada(posicion.getX(), posicion.getY() - (factorMovY));
	}

	@Override
	public Coordenada nextPosMovDown() {
		return new Coordenada(posicion.getX(), posicion.getY() + (factorMovY));
	}
}
