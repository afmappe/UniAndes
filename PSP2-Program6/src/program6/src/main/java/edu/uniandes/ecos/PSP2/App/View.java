package edu.uniandes.ecos.PSP2.App;

import java.util.Scanner;

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
	public void renderMenu() {
		try {
			int op = 0;
			scanner = new Scanner(System.in);
			String message = "Insert the number of the option you want to execute\n" + "1. Run Example\n"
					+ "2. Insert values\n" + "3. Finish";
			do {

				printMessage(message);
				op = scanner.nextInt();
				switch (op) {
				case 1:
					execute(0.2, 6);
					execute(0.45, 15);
					execute(0.495, 4);
					System.in.read();
					break;
				case 2:
					printMessage("Write P Value");
					double p = scanner.nextDouble();
					printMessage("Write Dof Value");
					double dof = scanner.nextDouble();
					execute(p, dof);
					System.in.read();
					break;
				case 3:
					break;
				default:
					printMessage("Please enter a valid option");
					break;
				}

			} while (op != 3);
			scanner.close();
		} catch (Exception e) {
			printError(e.getMessage());
		}

	}

	/**
	 * Llama al controlador para ejecutar la tarea
	 */
	private void execute(double a, double b) {

		SimpsonRuleInfo data = controller.execute(a, b);

		String response = String.format("Calculate Simpson Eule\nX: %1$.5f\nDof: %2$.4f\nP: %3$.6f", data.getX(),
				data.getDof(), data.getValue());
		printMessage(response);

	}

}