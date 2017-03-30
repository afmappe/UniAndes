package edu.uniandes.ecos.PSP2.Interfaces;

import edu.uniandes.ecos.PSP2.Entities.RelativeSizeInfo;

public interface IController {

	/**
	 * LLama al modelo para invocar el metodo que se debe ejecutar
	 * 
	 * @param fileName
	 *            nombre del archivo
	 * @return resultado del metodo invocado en el modelo
	 */
	RelativeSizeInfo execute(String fileName);
}
