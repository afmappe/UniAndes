package edu.uniandes.ecos.PSP2.Entities;

/**
 * Datos de tamaño relativo
 * 
 * @author af.mape
 *
 */
public class RelativeSizeInfo {

	/**
	 * Elementos que se deben evaluar
	 */
	double[] items;

	/**
	 * Elemento mas pequeños
	 */
	private double verySmall;

	/**
	 * Elemento pequeños
	 */
	private double small;

	/**
	 * Elemento medianos
	 */
	private double medium;

	/**
	 * Elemento grandes
	 */
	private double large;

	/**
	 * Elemento mas grandes
	 */
	private double veryLarge;

	/**
	 * Constructor por defecto
	 * 
	 * @param data
	 *            elementos
	 * @param average
	 *            promedio
	 * @param standardDeviation
	 *            desviacion estandar
	 */
	public RelativeSizeInfo(double[] data, double average, double standardDeviation) {

		double lnVS = average - 2 * standardDeviation;
		double lnS = average - standardDeviation;
		double lnM = average;
		double lnL = average + standardDeviation;
		double lnVL = average + 2 * standardDeviation;

		items = data;
		verySmall = Math.exp(lnVS);
		small = Math.exp(lnS);
		medium = Math.exp(lnM);
		large = Math.exp(lnL);
		veryLarge = Math.exp(lnVL);
	}

	/**
	 * Obtiene el valor mas pequeño
	 * 
	 * @return verySmall
	 */
	public double getVerySmall() {
		return verySmall;
	}

	/**
	 * Obtiene el valor pequeño
	 * 
	 * @return small
	 */
	public double getSmall() {
		return small;
	}

	/**
	 * Obtiene el valor Medio
	 * 
	 * @return medium
	 */
	public double getMedium() {
		return medium;
	}

	/**
	 * Obtiene el valor grande
	 * 
	 * @return large
	 */
	public double getLarge() {
		return large;
	}

	/**
	 * Obtiene el valor mas grande
	 * 
	 * @return veryLarge
	 */
	public double getVeryLarge() {
		return veryLarge;
	}

	/**
	 * Obtiene el listado de elementos
	 * 
	 * @return items
	 */
	public double[] getItems() {
		return items;
	}

}
