package edu.uniandes.ecos.PSP2.App;

import edu.uniandes.ecos.PSP2.Interfaces.IView;;

/**
 * Inicio de la aplicacion
 * 
 * @author af.mape
 *
 */
public class App {
	/**
	 * Metodo de entrada
	 */
	public static void main(String[] args) {
		IView view = new View();
		view.renderMenu();
	}
}
