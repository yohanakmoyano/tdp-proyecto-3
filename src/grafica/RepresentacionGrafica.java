package grafica;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RepresentacionGrafica {
	protected JLabel dibujo;
	protected String ruta; 
	protected int altura; 
	protected int base; 
	protected int actualizarMov;
	
	public RepresentacionGrafica(String r, int x, int y, int ancho, int alto) {
		ruta = r;
		altura = alto;
		base = alto;
		ImageIcon imagen = null;
		dibujo = new JLabel();
		dibujo.setBounds(x, y, ancho, alto);
		try {
			imagen = new ImageIcon(new URL(r));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		Image medidaEntidad = imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
		dibujo.setIcon(new ImageIcon(medidaEntidad));
	}
	
	//se mueve + en el eje x
	public void moverDerecha() {
		actualizarMov = dibujo.getX() + (base/2);
		dibujo.setBounds(actualizarMov, dibujo.getY(), base, altura);
	}
	
	//se mueve - en el eje x
	public void moverIzquierda() {
		actualizarMov = dibujo.getX() - (base/2);
		dibujo.setBounds(actualizarMov, dibujo.getY(), base, altura);
	}
	
	//se mueve - en el eje y
	public void moverArriba() {
		actualizarMov = dibujo.getY() - (altura/2);
		dibujo.setBounds(dibujo.getX(), actualizarMov, base, altura);
	}
	
	//se mueve + en el eje y
	public void moverAbajo() {
		actualizarMov = dibujo.getY() + (altura/2);
		dibujo.setBounds(dibujo.getX(), actualizarMov, base, altura);
	}
	
	public void eliminar() {
		dibujo.setBounds(0, 0, 0, 0);
	}
	
	public void moverRep(int x, int y) {
		dibujo.setBounds(x, y, base, altura);
	}
	
	public boolean colisiona(RepresentacionGrafica r) {
		return this.dibujo.getBounds().intersects(r.getDibujo().getBounds());
	}
	
	public String getRuta() {
		return ruta;
	}
	
	public JLabel getDibujo() {
		return dibujo;
	}
	
	public void cambiarRuta(String r) {
		ruta = r;
	}
}
