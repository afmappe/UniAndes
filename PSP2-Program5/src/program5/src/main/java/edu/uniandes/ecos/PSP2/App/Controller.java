package edu.uniandes.ecos.PSP2.App;

import java.nio.file.Path;

import edu.uniandes.ecos.PSP2.Business.SimpsonRule;
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
	private SimpsonRule simpson;

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
	public SimpsonRuleInfo execute(double x, double dof) {
		SimpsonRuleInfo data = null;
		try {
			simpson = new SimpsonRule(x, dof);
			data = simpson.calculate();
		} catch (Exception e) {
			this.view.printError(e.getMessage());
		}

		return data;
	}

}
