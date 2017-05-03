package edu.uniandes.ecos.PSP2.Business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Lee archivos de texto
 * 
 * @author af.mape
 *
 */
public class FileReader {

	/**
	 * Obtiene el path de un archivo a partir de la ruta
	 * 
	 * @param stringPath
	 *            ruta del archivo
	 * @return ruta del archivo
	 */
	public static Path pathFromString(String stringPath) {
		Path path = Paths.get(stringPath);
		return path;
	}

	/**
	 * Obtiene la ruta de un archivo a partir de path
	 * 
	 * @param path
	 *            path del archivo
	 * @return Ruta del archivo
	 * @throws IOException
	 */
	public static String fileToString(Path path) throws IOException {
		byte[] data = Files.readAllBytes(path);
		String content = new String(data);
		return content;
	}

}
