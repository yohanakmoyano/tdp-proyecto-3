package grafica;

public class RepresentacionGrafica {
	
	protected String ruta; 
	protected int altura; 
	protected int base; 
	
	public RepresentacionGrafica(String r) {
		ruta = r;
	}
	
	public String getRuta() {
		return ruta;
	}
	
	public void cambiarRuta(String r) {
		ruta = r;
	}
}
