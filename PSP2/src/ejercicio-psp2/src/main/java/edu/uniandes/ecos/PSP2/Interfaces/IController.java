package edu.uniandes.ecos.PSP2.Interfaces;

import edu.uniandes.ecos.PSP2.Entities.DataInfo;

public interface IController {
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	DataInfo execute(String fileName);
}
