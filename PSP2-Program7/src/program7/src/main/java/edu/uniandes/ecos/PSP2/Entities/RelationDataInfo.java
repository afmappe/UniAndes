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
	 * Coeficiente de correlacion
	 */
	private double rxy;

	/**
	 * Valor calculado de la ecuacion
	 */
	private double yk;

	/**
	 * Parametro B0 de la regresion lineal
	 */
	private Double regressionParamenterB0;

	/**
	 * Parametro B1 de la regresion lineal
	 */
	private Double regressionParamenterB1;

	/**
	 * Constructor por defecto
	 * 
	 * @param b0
	 *            Parametro B0 de la regresion lineal
	 * @param b1
	 *            Parametro B1 de la regresion lineal
	 * @param coefficient
	 *            Coeficiente de correlacion
	 */
	public RelationDataInfo(double b0, double b1, double xavg, double yavg, double coefficient) {
		regressionParamenterB0 = b0;
		regressionParamenterB1 = b1;
		setxAvg(xavg);
		setyAvg(yavg);
		rxy = coefficient;
	}

	/**
	 * Coeficiente de correlacion
	 * @return Coeficiente de correlacion
	 */
	public double getCorrelationCoefficient() {
		return rxy;
	}

	/**
	 * 
	 * @return Coeficiente de correlacion
	 */
	public double getR2() {
		return Math.pow(rxy, 2);
	}

	/**
	 * 
	 * @return Parametro B0 de la regresion lineal
	 */
	public Double getParameterB0() {
		return regressionParamenterB0;
	}

	/**
	 * 
	 * @return Parametro B1 de la regresion lineal
	 */
	public Double getParameterB1() {
		return regressionParamenterB1;
	}

	/**
	 * Parametro yk de la regresion lineal
	 * 
	 * @return yk
	 */
	public double getYk() {
		return yk;
	}

	/**
	 * Asigna el valor de yk
	 * 
	 * @param xk
	 */
	public void setYk(double xk) {
		this.yk = regressionParamenterB0 + regressionParamenterB1 * xk;
	}

	/**
	 * Obtine el promedio de los valores de y
	 * 
	 * @return yAvg
	 */
	public double getyAvg() {
		return yAvg;
	}

	/**
	 * Asigna el valor de yAvg
	 * 
	 * @param yAvg
	 *            promedio de los valores de y
	 */
	public void setyAvg(double yAvg) {
		this.yAvg = yAvg;
	}

	/**
	 * Obtine el promedio de los valores de x
	 * 
	 * @return xAvg promedio de los valores de x
	 */
	public double getxAvg() {
		return xAvg;
	}

	/**
	 * Asigna el promedio de los valores de x
	 * 
	 * @param xAvg
	 *            promedio de los valores de x
	 */
	public void setxAvg(double xAvg) {
		this.xAvg = xAvg;
	}

}
