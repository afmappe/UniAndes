package edu.uniandes.ecos.PSP2.Interfaces;

import edu.uniandes.ecos.PSP2.Entities.RelativeSizeInfo;

public interface IController {

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	RelativeSizeInfo execute(String fileName);
}
