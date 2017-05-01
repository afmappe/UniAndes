package edu.uniandes.ecos.PSP2.Entities;

/**
 * 
 * @author andres.mape
 *
 */
public class RelationDataInfo {

	/**
	 * Valor promedio de x
	 */
	private double xAvg;

	/**
	 * valor promedio de y
	 */
	private double yAvg;

	/**
	 * Coeficiente de correlación
	 */
	private double rxy;

	/**
	 * Valor calculado de la ecuacion
	 */
	private double yk;

	/**
	 * Parámetro B0 de la regresión lineal
	 */
	private Double regressionParamenterB0;

	/**
	 * Parámetro B1 de la regresión lineal
	 */
	private Double regressionParamenterB1;

	/**
	 * Constructor por defecto
	 * 
	 * @param b0
	 *            Parámetro B0 de la regresión lineal
	 * @param b1
	 *            Parámetro B1 de la regresión lineal
	 * @param coefficient
	 *            Coeficiente de correlación
	 */
	public RelationDataInfo(double b0, double b1, double xavg, double yavg, double coefficient) {
		regressionParamenterB0 = b0;
		regressionParamenterB1 = b1;
		setxAvg(xavg);
		setyAvg(yavg);
		rxy = coefficient;
	}

	/**
	 * 
	 * @return Coeficiente de correlación
	 */
	public double getCorrelationCoefficient() {
		return rxy;
	}

	/**
	 * 
	 * @return Coeficiente de correlación
	 */
	public double getR2() {
		return Math.pow(rxy, 2);
	}

	/**
	 * 
	 * @return Parámetro B0 de la regresión lineal
	 */
	public Double getParameterB0() {
		return regressionParamenterB0;
	}

	/**
	 * 
	 * @return Parámetro B1 de la regresión lineal
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

	public double getyAvg() {
		return yAvg;
	}

	public void setyAvg(double yAvg) {
		this.yAvg = yAvg;
	}

	public double getxAvg() {
		return xAvg;
	}

	public void setxAvg(double xAvg) {
		this.xAvg = xAvg;
	}

}
