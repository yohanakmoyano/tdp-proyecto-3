package entidades.movibles.enemigos;

import entidades.movibles.EntidadMovible;
import entidades.movibles.jugadores.Jugador;
import logica.Salon;
import patrones.strategy_enem.Asesino;
import patrones.strategy_enem.Presa;
import patrones.strategy_enem.StrategyEnemy;

public abstract class Enemigo extends EntidadMovible {
	protected int valor;
	protected StrategyEnemy miEstrategia;
	protected Jugador elJugador;
	protected Salon miSalon = Salon.getInstance();
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void setJugador(Jugador jug) {
		miEstrategia.setJugador(jug);
		elJugador = jug;
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public int getValor() {
		return valor;
	}

	public void modoPresaOn() {
		miEstrategia = new Presa();
		miEstrategia.setEnemigo(this);
		miEstrategia.setJugador(elJugador);
	}
	
	public void modoAsesinoOn() {
		miEstrategia = new Asesino();
		miEstrategia.setEnemigo(this);
		miEstrategia.setJugador(elJugador);
	}
	
	@Override
	public void morir() {
		this.isDead();
		miRep.moverRep(miSalon.getRespawnPoint().getX(), miSalon.getRespawnPoint().getY());
		posicion.setX(miSalon.getRespawnPoint().getX());
		posicion.setY(miSalon.getRespawnPoint().getY());
		ultMovimiento = REPOSO;
		movEnCola = REPOSO;
		puedoMovermeIzq = true;
		puedoMovermeDer = true;
		puedoMovermeUp = true;
		puedoMovermeDown =true;
		
		this.revive();
	}

}
