package edu.uniandes.ecos.PSP2.App;

import java.util.Arrays;
import java.util.Scanner;

import edu.uniandes.ecos.PSP2.Entities.RelativeSizeInfo;
import edu.uniandes.ecos.PSP2.Interfaces.IController;
import edu.uniandes.ecos.PSP2.Interfaces.IView;

/**
 * Representa la vista se encarga de recibir los datos y imprimir mensajes
 * 
 * @author af.mape
 * 
 */
public class View implements IView {

	/**
	 * Instancia que representa el controlador
	 */
	private IController controller;

	/**
	 * Captura los eventos de teclado
	 */
	private Scanner scanner;

	/**
	 * Constructor por defecto
	 */
	public View() {
		controller = new Controller(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printError(String error) {
		String s = String.format("Error Message: %1s", error);
		printMessage(s);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printMessage(String message) {
		System.out.flush();
		System.out.println(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFilePath() {

		String path = null;
		do {
			scanner.nextLine();
			printMessage("Write path File");
			path = scanner.nextLine();

		} while (path == null || path.trim().length() <= 0);

		return path;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void renderMenu() {

		int op = 0;
		scanner = new Scanner(System.in);
		String message = "Insert the number of the option you want to execute\n" + "1. Type the path of the file\n"
				+ "2. Finish";
		do {

			printMessage(message);
			op = scanner.nextInt();
			switch (op) {
			case 1:
				execute();
				break;
			case 2:
				break;

			default:
				printMessage("Please enter a valid option");
				break;
			}

		} while (op != 2);
		scanner.close();

	}

	/**
	 * Llama al controlador para ejecutar la tarea
	 */
	private void execute() {
		try {
			String path = getFilePath();
			RelativeSizeInfo data = controller.execute(path);

			if (data != null) {
				String items = Arrays.toString(data.getItems());
				String response = String.format(
						"Calculating a relative size table using standard deviation\nItems: %1s\nVerySmall: %2$.4f\nSmall: %3$.4f\nMediun: %4$.4f\nLarge: %5$.4f\nVery Large %6$.4f\n",
						items, data.getVerySmall(), data.getSmall(), data.getMedium(), data.getLarge(),
						data.getVeryLarge());
				printMessage(response);
			} else {
				printError("Internal error");
			}

			System.in.read();
		} catch (Exception e) {
			printError(e.getMessage());
		}
	}

}