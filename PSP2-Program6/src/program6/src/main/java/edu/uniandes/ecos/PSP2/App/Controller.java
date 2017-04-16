package edu.uniandes.ecos.PSP2.App;

import edu.uniandes.ecos.PSP2.Business.SearchAlgorithm;
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
	private SearchAlgorithm search;

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
	}

	/**
	 * Llama al modelo para ejecutar la tarea
	 */
	public SimpsonRuleInfo execute(double p, double dof) {
		SimpsonRuleInfo data = null;
		try {
			search = new SearchAlgorithm();
			data = search.test(p, dof);
		} catch (Exception e) {
			this.view.printError(e.getMessage());
		}

		return data;
	}

}
