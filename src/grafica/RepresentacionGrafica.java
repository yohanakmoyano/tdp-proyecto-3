package grafica;

import java.awt.Rectangle;
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
		//System.out.println("--------------------------Grafica-------------------------------------------------------------");
		actualizarMov = dibujo.getX() + (base/2);
		//System.out.println("Coordenada Label: ("+dibujo.getX()+", "+dibujo.getY()+")");
		//dibujo.setX(actualizarMov);
		//dibujo.getBounds().setLocation(actualizarMov, dibujo.getY());
		dibujo.setBounds(actualizarMov, dibujo.getY(), base, altura);
		//System.out.println("Coordenada Label: ("+dibujo.getX()+", "+dibujo.getY()+")");
		//System.out.println("-----------------------------------------------------------------------------------------------");
	}
	
	//se mueve - en el eje x
	public void moverIzquierda() {
		//System.out.println("--------------------------Grafica-------------------------------------------------------------");
		actualizarMov = dibujo.getX() - (base/2);
		//System.out.println("Coordenada Label: ("+dibujo.getX()+", "+dibujo.getY()+")");
		//dibujo.getBounds().setLocation(actualizarMov, dibujo.getY());		
		dibujo.setBounds(actualizarMov, dibujo.getY(), base, altura);
		//System.out.println("Coordenada Label: ("+dibujo.getX()+", "+dibujo.getY()+")");
		//System.out.println("-----------------------------------------------------------------------------------------------");
	}
	
	//se mueve - en el eje y
	public void moverArriba() {
		//System.out.println("--------------------------Grafica-------------------------------------------------------------");
		actualizarMov = dibujo.getY() - (altura/2);
		//dibujo.setY(actualizarMov);
		//System.out.println("Coordenada Label: ("+dibujo.getX()+", "+dibujo.getY()+")");
		//dibujo.getBounds().setLocation(dibujo.getX(), actualizarMov);		
		dibujo.setBounds(dibujo.getX(), actualizarMov, base, altura);
		//System.out.println("Coordenada Label: ("+dibujo.getX()+", "+dibujo.getY()+")");
		//System.out.println("-----------------------------------------------------------------------------------------------");
	}
	
	//se mueve + en el eje y
	public void moverAbajo() {
		//System.out.println("--------------------------Grafica-------------------------------------------------------------");
		actualizarMov = dibujo.getY() + (altura/2);
		//dibujo.setY(actualizarMov);
		//System.out.println("Coordenada Label: ("+dibujo.getX()+", "+dibujo.getY()+")");
		//dibujo.getBounds().setLocation(dibujo.getX(), actualizarMov);	
		dibujo.setBounds(dibujo.getX(), actualizarMov, base, altura);
		//System.out.println("Coordenada Label: ("+dibujo.getX()+", "+dibujo.getY()+")");
		//System.out.println("-----------------------------------------------------------------------------------------------");
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
