package edu.uniandes.ecos.PSP2.Business;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Utilidad para leer archivo
 * 
 * @author af.mape
 *
 */
public class FileReader {

	/**
	 * Obtiene el path del archivo
	 * 
	 * @param stringPath
	 *            ruta del archivo
	 * @return path del archivo
	 */
	public static Path pathFromString(String stringPath) {
		Path path = Paths.get(stringPath);
		return path;
	}

	/**
	 * Obtiene los datos de un archivo de texto
	 * 
	 * @param path
	 *            path del archivo
	 * @return texto con la informacion del archivo
	 * @throws IOException
	 */
	public static String fileToString(Path path) throws IOException {
		byte[] data = Files.readAllBytes(path);
		String content = new String(data);
		return content;
	}

	/**
	 * Obtiene el path de un archivo de recursos
	 * 
	 * @param resourceName
	 *            nombre del recurso
	 * @return path de un archivo de recursos
	 */
	public static Path getResourcePath(String resourceName) {
		Path path = null;
		try {
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			URL url = classLoader.getResource(resourceName);
			path = Paths.get(url.toURI());
		} catch (URISyntaxException e) {

		}
		return path;
	}

}
