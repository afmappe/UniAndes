package edu.uniandes.ecos.PSP2.Interfaces;

/**
 * Representa la vista se encarga de recibir los datos y imprimir mensajes
 * 
 * @author af.mape
 *
 */
public interface IView {

	/**
	 * Imprime errores
	 * 
	 * @param error
	 *            Mensaje de error
	 */
	void printError(String error);

	/**
	 * Imprime mensajes
	 * 
	 * @param message
	 *            Mensaje
	 */
	void printMessage(String message);

	/**
	 * Imprime el menu de la aplicación
	 */
	void renderMenu();
}
