package edu.uniandes.ecos.PSP2.Interfaces;

import edu.uniandes.ecos.PSP2.Entities.SimpsonRuleInfo;

public interface IController {

	/**
	 * LLama al modelo para invocar el metodo que se debe ejecutar
	 * 
	 * @param fileName
	 *            nombre del archivo
	 * @return resultado del metodo invocado en el modelo
	 */
	SimpsonRuleInfo execute(double x, double dof);
}
