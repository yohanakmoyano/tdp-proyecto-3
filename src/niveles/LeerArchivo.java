package niveles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivo {

	public static List<String> leer(String ruta) {
		String linea;

		List<String> lista = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);
			while ((linea = br.readLine()) != null) {
				lista.add(linea);
			}

			fr.close();

		} catch (IOException r) {
			System.out.println("Error al procesar el archivo");
		}
		return lista;
	}

}
