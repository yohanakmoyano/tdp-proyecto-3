package Dominio;

import Entidad.Enemigo;
import Entidad.Item;
import Entidad.Jugador;

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
}
