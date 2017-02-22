package uniandes.ecos.psp.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Logica de negocio para contar lineas de codigo y metodos en un archivo de
 * texto
 * 
 * @author afmape
 * 
 */
public class Model {

	/**
	 * Expresion regular para determinar el numero de metodos de un archivo de
	 * texto
	 */
	private static final String ITEMS_COUNT = "^[ \\t](public|private|static|final).*\\(.*(\\{)$";

	/**
	 * Expresion regular para determinar el numero de lineas funcionales de
	 * archivo de texto
	 */
	private static final String LOC_SIZE = "^(?![ \\s]*\\r?\\n|[ \\s]*}\\r?\\n|[ \\s]*\\/\\/|[ \\s]*\\/\\*|[ \\s]*\\*).*\\r?\\n";

	/**
	 * Permite leer opciones por teclado
	 */
	private Scanner scanner;

	/**
	 * Evalua las expresiones regulares para determinar el numero de lineas de
	 * codigo y de metodos de un archivo de texto
	 * 
	 * @param file
	 *            Archivo de texto
	 * @return Un Instancia que representa un archivo con sus metricas de codigo
	 * @throws FileNotFoundException
	 */
	public FileInfo evaluate(File file) throws FileNotFoundException {
		FileInfo result = null;

		if (file != null) {
			scanner = new Scanner(file);
			String text = scanner.useDelimiter("\\Z").next();

			result = new FileInfo(file.getName(),
					countMaches(text, ITEMS_COUNT), countMaches(text, LOC_SIZE));

		}
		return result;

	}

	/**
	 * Evalua las expresiones regulares y cuenta coincidencias
	 * 
	 * @param text
	 *            cadena de texto
	 * @param expression
	 *            Expresion regular
	 * @return numero de coincidencias
	 */
	private int countMaches(String text, String expression) {
		int count = 0;
		Pattern pattern = Pattern.compile(expression, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			count++;
		}
		return count;
	}

}
