package Grafica;

public class RepresentacionGrafica {
	
	protected String ruta; 
	
	public RepresentacionGrafica(String r) {
		ruta=r;
	}
	
	public String getRuta() {
		return ruta;
	}
	
	public void cambiarRuta(String r) {
		ruta=r;
	}
}
