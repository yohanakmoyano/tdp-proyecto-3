package dominio;

import entidades.movibles.enemigos.Enemigo;
import entidades.movibles.jugadores.Jugador;
import entidades.nomovibles.Bloque;
import entidades.nomovibles.Item;

public abstract class FactoryDominio {
public abstract  Jugador crearJugador();	
public abstract Enemigo crearEnemigoA();
public abstract Enemigo crearEnemigoB();
public abstract Enemigo crearEnemigoC();
public abstract Enemigo crearEnemigoD();
public abstract Item CrearItemA();
public abstract Item CrearItemB();
public abstract Item CrearItemC();
public abstract Item CrearItemD();
public abstract Item CrearItemE();
public abstract Bloque CrearBloque();
}
