package Logica;

public class Zona {
	
	private int base;
	private int altura;

	public Zona(int b ,int a) {
		base=b;
		altura=a;
	}
	
	public int Area() {
		return base*altura;
	}
	
	public void setBase(int b) {
		base=b;
	}
	
	public int getBase() {
		return base; 
	}
	
	public void setAltura(int a) {
		altura=a; 
	}
	
	public int getAltura() {
		return altura; 
	}
}
