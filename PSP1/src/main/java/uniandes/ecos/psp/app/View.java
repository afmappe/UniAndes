package uniandes.ecos.psp.app;

import java.util.Scanner;

/**
 * Representa la vista se encarga de recibir los datos y imprimir mensajes
 * 
 * @author af.mape
 * 
 */
public class View {

	/**
	 * Instancia que representa el controlador
	 */
	private Controller controller;

	/**
	 * 
	 */
	private Scanner keyboard;

	/**
	 * Constructor por defecto
	 */
	public View() {
		controller = new Controller(this);
		renderMenu();
	}

	/**
	 * Imprime errores
	 * 
	 * @param error
	 *            Mensaje de error
	 */
	public void printError(String error) {
		String s = String.format("Error Message: %1s", error);
		printMessage(s);

	}

	/**
	 * Imprime mensajes
	 * 
	 * @param message
	 *            Mensaje
	 */
	public void printMessage(String message) {
		System.out.println(message);
	}

	/**
	 * Pinta el menu de opciones
	 */
	private void renderMenu() {
		int op = 0;
		keyboard = new Scanner(System.in);
		String s = "Insert the number of the option you want to execute\n" + "1. Type the path of the file or folder\n"
				+ "2. Finish";

		do {
			System.out.flush();
			printMessage(s);
			op = keyboard.nextInt();

			switch (op) {
			case 1:
				System.out.flush();
				printMessage("Type the path of the file or folder\n");		
				keyboard.nextLine();
				String path = keyboard.nextLine();		
				controller.listFilesForFolder(path);
				controller.processData();				
				break;
			case 3:
				break;

			default:
				printMessage("Please enter a valid option");
				break;
			}

		} while (op != 3);
	}

}
