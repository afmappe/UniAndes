package edu.uniandes.ecos.PSP2.App;

import java.nio.file.Path;

import edu.uniandes.ecos.PSP2.Business.FileReader;
import edu.uniandes.ecos.PSP2.Business.RelativeSize;
import edu.uniandes.ecos.PSP2.Entities.RelativeSizeInfo;
import edu.uniandes.ecos.PSP2.Interfaces.IController;
import edu.uniandes.ecos.PSP2.Interfaces.IView;

/**
 * Controlador de la vista
 * 
 * @author af.mape
 *
 */
public class Controller implements IController {

	/**
	 * Intancia que calcula el tamaño relativo
	 */
	private RelativeSize relativeSize;

	/**
	 * Instancia que representa la vista
	 */
	private IView view;

	/**
	 * Constructor por defecto
	 * 
	 * @param view
	 *            Vista para pintar el modelo
	 */
	public Controller(IView view) {
		this.view = view;
		relativeSize = new RelativeSize();

	}

	/**
	 * Llama al modelo para ejecutar la tarea
	 */
	public RelativeSizeInfo execute(String fileName) {
		RelativeSizeInfo data = null;
		try {
			Path filePath = FileReader.pathFromString(fileName);
			String content = FileReader.fileToString(filePath);
			data = getFileData(content);
		} catch (Exception e) {
			this.view.printError(e.getMessage());
		}

		return data;
	}

	/**
	 * Obtiene los datos del archivo de texto
	 * 
	 * @param data
	 *            informacion del texto
	 * 
	 * @return informacion del tamaño relativo
	 */
	private RelativeSizeInfo getFileData(String data) {

		RelativeSizeInfo result = null;

		try {
			String[] lines = data.split(System.getProperty("line.separator"));

			if (lines != null && lines.length > 0) {
				if (lines[0].equalsIgnoreCase("Data")) {
					result = processData(lines);
				} else {
					throw new Exception("Invalid format first row should be x;y;loc");
				}
			} else {
				throw new Exception("There are not elements ");
			}

		} catch (Exception e) {
			this.view.printError(e.getMessage());
		}

		return result;
	}

	/**
	 * Envia los datos al modelo
	 * 
	 * @param lines
	 *            Arreglo de lineas del texto a procesar
	 * @return informacion del tamaño relativo
	 * @throws Exception
	 *             por problemas al convertir los datos
	 */
	private RelativeSizeInfo processData(String[] lines) throws Exception {
		int count = lines.length - 1;
		double[] data = new double[count];

		for (int i = 1; i < count + 1; i++) {
			data[i - 1] = Double.parseDouble(lines[i]);
		}
		return relativeSize.Calculate(data);
	}
}
