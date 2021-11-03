package Strategy;

import Entidad.Enemigo;

public abstract class StrategyJugador {
protected Strategy estrategia;
public void setStrategy(Strategy est) {
estrategia=est;
}
public void atacar(Enemigo op) {
	
}
}
