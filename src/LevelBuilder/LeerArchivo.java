package LevelBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivo {

	 
	public static List<String> leer(String ruta) {
		String linea;
		int cant=0;
		
		List<String> lista =new ArrayList<String>();
		int j = 0;
		try {
			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);
			while ((linea = br.readLine()) != null) { // en cada linea
				lista.add(linea);
				//System.out.println(arreglo[j]);
				j++;
			}

			fr.close();

		} catch (IOException r) {
			System.out.println("Error al procesar el archivo");
		}
		return lista;
	}
	
}
