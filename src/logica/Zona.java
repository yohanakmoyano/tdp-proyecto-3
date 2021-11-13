package logica;

import java.util.ArrayList;
import java.util.List;

import entidades.Entidad;

public class Zona {
	
	protected Coordenada esquinaIzqSuperior;
	protected Coordenada esquinaDerSuperior;
	protected Coordenada esquinaIzqInferior;
	protected Coordenada esquinaDerInferior;
	protected List<Entidad> listaEntidades; 

	public Zona(Coordenada esqIzqSup, Coordenada esqDerSup, Coordenada esqIzqInf, Coordenada esqDerInf) {
		esquinaIzqSuperior=esqIzqSup;
		esquinaDerSuperior=esqDerSup; 
		esquinaIzqInferior=esqIzqInf;
		esquinaDerInferior=esqIzqInf;
		listaEntidades= new ArrayList<Entidad>(); 
	}
	
	public Coordenada getEsquinaIzqSup() {
		return esquinaIzqSuperior; 
	}
	
	public Coordenada getEsquinaDerSup() {
		return esquinaDerSuperior; 
	}
	
	public Coordenada getEsquinaIzqInf() {
		return esquinaIzqInferior;
	}
	
	public Coordenada getEsquinaDerInf() {
		return esquinaDerInferior;
	}
	
	public List<Entidad> getListaEntidades() {
		return listaEntidades;
	}
	
	public void agregarEntidad(Entidad e) {
		listaEntidades.add(e);
	}
	
	public void eliminarEntidad(Entidad e) {
		listaEntidades.remove(e);
	}	
	
}
