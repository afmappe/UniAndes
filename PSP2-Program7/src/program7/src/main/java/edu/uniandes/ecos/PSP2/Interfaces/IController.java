package edu.uniandes.ecos.PSP2.Interfaces;

import edu.uniandes.ecos.PSP2.Entities.DataInfo;

/**
 * Contolador de la vista
 * 
 * @author af.mape
 *
 */
public interface IController {

	/**
	 * LLama al modelo para invocar el metodo que se debe ejecutar
	 * 
	 * @param fileName
	 *            ruta del archivo
	 * @return resultado del metodo invocado en el modelo
	 */
	DataInfo execute(String fileName);
}
