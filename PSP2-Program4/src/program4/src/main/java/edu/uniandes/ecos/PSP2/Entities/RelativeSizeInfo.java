package edu.uniandes.ecos.PSP2.Entities;

/**
 * 
 * @author af.mape
 *
 */
public class RelativeSizeInfo {

	/**
	 * 
	 */
	double[] items;

	/**
	 * 
	 */
	private double verySmall;

	/**
	 * 
	 */
	private double small;

	/**
	 * 
	 */
	private double medium;

	/**
	 * 
	 */
	private double large;

	/**
	 * 
	 */
	private double veryLarge;

	/**
	 * 
	 * @param average
	 * @param standardDeviation
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
	 * 
	 * @return
	 */
	public double getVerySmall() {
		return verySmall;
	}

	/**
	 * 
	 * @return
	 */
	public double getSmall() {
		return small;
	}

	/**
	 * 
	 * @return
	 */
	public double getMedium() {
		return medium;
	}

	/**
	 * 
	 * @return
	 */
	public double getLarge() {
		return large;
	}

	/**
	 * 
	 * @return
	 */
	public double getVeryLarge() {
		return veryLarge;
	}

	/**
	 * 
	 * @return
	 */
	public double[] getItems() {
		return items;
	}

}
