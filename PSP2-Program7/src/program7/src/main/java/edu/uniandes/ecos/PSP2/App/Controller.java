package edu.uniandes.ecos.PSP2.App;

import java.nio.file.Path;

import edu.uniandes.ecos.PSP2.Business.FileReader;
import edu.uniandes.ecos.PSP2.Business.SearchAlgorithm;
import edu.uniandes.ecos.PSP2.Business.PspData;
import edu.uniandes.ecos.PSP2.Entities.DataInfo;
import edu.uniandes.ecos.PSP2.Entities.SimpsonRuleInfo;
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
	private PspData temp;

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
		this.temp = new PspData();
	}

	/**
	 * Llama al modelo para ejecutar la tarea
	 */
	public DataInfo execute(String fileName) {
		DataInfo data = null;
		try {
			Path filePath = FileReader.pathFromString(fileName);
			String content = FileReader.fileToString(filePath);
			data = processData(content);
		} catch (Exception e) {
			this.view.printError(e.getMessage());
		}

		return data;
	}

	private DataInfo processData(String data) {

		DataInfo result = null;

		try {
			String[] lines = data.split(System.getProperty("line.separator"));

			if (lines != null && lines.length > 0) {
				if (lines[0].equalsIgnoreCase("x;y;loc")) {
					result = internalProcessData(lines);
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

	private DataInfo internalProcessData(String[] lines) {
		int count = lines.length - 1;
		double[] x = new double[count];
		double[] y = new double[count];
		double xk = 0;

		String[] line = lines[1].split(";");
		xk = Double.parseDouble(line[2]);

		for (int i = 1; i < count + 1; i++) {
			line = lines[i].split(";");
			x[i - 1] = Double.parseDouble(line[0]);
			y[i - 1] = Double.parseDouble(line[1]);
		}
		return temp.calculate(x, y, xk);
	}
}
