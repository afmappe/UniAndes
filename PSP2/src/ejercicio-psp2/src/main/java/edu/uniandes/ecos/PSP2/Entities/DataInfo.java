package edu.uniandes.ecos.PSP2.Entities;

/**
 * 
 * @author andres.mape
 *
 */
public class DataInfo {

	/**
	 * Coeficiente de correlaci�n
	 */
	private double rxy;

	/**
	 * 
	 */
	private double yk;

	/**
	 * Par�metro B0 de la regresi�n lineal
	 */
	private Double regressionParamenterB0;

	/**
	 * Par�metro B1 de la regresi�n lineal
	 */
	private Double regressionParamenterB1;

	/**
	 * Constructor por defecto
	 * 
	 * @param b0
	 *            Par�metro B0 de la regresi�n lineal
	 * @param b1
	 *            Par�metro B1 de la regresi�n lineal
	 * @param coefficient
	 *            Coeficiente de correlaci�n
	 */
	public DataInfo(double b0, double b1, double coefficient) {
		regressionParamenterB0 = b0;
		regressionParamenterB1 = b1;
		rxy = coefficient;
	}

	/**
	 * 
	 * @return Coeficiente de correlaci�n
	 */
	public double getCorrelationCoefficient() {
		return rxy;
	}

	/**
	 * 
	 * @return Coeficiente de correlaci�n
	 */
	public double getR2() {
		return Math.pow(rxy, 2);
	}

	/**
	 * 
	 * @return Par�metro B0 de la regresi�n lineal
	 */
	public Double getParameterB0() {
		return regressionParamenterB0;
	}

	/**
	 * 
	 * @return Par�metro B1 de la regresi�n lineal
	 */
	public Double getParameterB1() {
		return regressionParamenterB1;
	}

	public double getYk() {
		return yk;
	}

	public void setYk(double xk) {
		this.yk = regressionParamenterB0 + regressionParamenterB1 * xk;
	}

}
