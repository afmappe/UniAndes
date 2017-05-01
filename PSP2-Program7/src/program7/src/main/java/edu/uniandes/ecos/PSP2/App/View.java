package edu.uniandes.ecos.PSP2.App;

import java.util.Scanner;

import edu.uniandes.ecos.PSP2.Entities.DataInfo;
import edu.uniandes.ecos.PSP2.Entities.SimpsonRuleInfo;
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
				+ "2. Finish\n";
		do {

			printMessage(message);
			op = scanner.nextInt();
			switch (op) {
			case 1:
				run();
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

	private void run() {
		try {
			String path = getFilePath();
			DataInfo data = controller.execute(path);
			String result = String.format(
					"rxy: %1f\nr2: %2f\nsignificance: %.12f\nB0: %4f\nB1: %5f\nYk: %6f\nRange: %7f\nUPI (70): %8f\nLPI (70); %9f\n",
					data.getRxy(), data.getR2(), data.getSig(), data.getB0(), data.getB1(), data.getYk(), data.getRange(),
					data.getUpi(), data.getLpi());

			printMessage(result);
			System.in.read();
		} catch (Exception e) {
			printError(e.getMessage());
		}
	}

}