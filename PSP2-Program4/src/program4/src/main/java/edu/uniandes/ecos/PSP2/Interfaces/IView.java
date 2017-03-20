package edu.uniandes.ecos.PSP2.Interfaces;

/**
 * Representa la vista se encarga de recibir los datos y imprimir mensajes
 * 
 * @author af.mape
 *
 */
public interface IView {

	/**
	 * Obtine el path de un archivo
	 * 
	 * @return cadena de texto que representa el path de un archivo
	 */
	String getFilePath();

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
