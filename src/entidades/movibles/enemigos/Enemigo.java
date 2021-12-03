package entidades.movibles.enemigos;

import entidades.movibles.EntidadMovible;
import entidades.movibles.jugadores.Jugador;
import logica.Coordenada;
import logica.Salon;
import logica.hilos.EnemiesThread;
import patrones.strategy_enem.Asesino;
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
		miEstrategia = new Asesino();
		miEstrategia.setEnemigo(this);
		miEstrategia.setJugador(jug);
		elJugador = jug;
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public int getValor() {
		return valor;
	}
	
	public abstract void mover(Coordenada posDest, int eje, EnemiesThread mov);

}
