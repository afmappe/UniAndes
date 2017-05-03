package edu.uniandes.ecos.PSP2.Entities;

/**
 * Representa la informacion de estimacion de PSP
 * 
 * @author af.mape
 *
 */
public class DataInfo {

	/**
	 * Coeficiente de correlacion
	 */
	private double rxy;

	/**
	 * Coeficiente de correlacion al cuadrado
	 */
	private double r2;

	/**
	 * Significancia
	 */
	private double sig;

	/**
	 * Parametro B0 de la regresion lineal
	 */
	private double b0;

	/**
	 * Parametro B1 de la regresion lineal
	 */
	private double b1;

	/**
	 * Parametro yk de la regresion lineal
	 */
	private double yk;

	/**
	 * Valor del rango
	 */
	private double range;

	/**
	 * Valor UPI 70%
	 */
	private double upi;

	/**
	 * Valor LPI 70%
	 */
	private double lpi;

	/**
	 * Constructor por defecto
	 * 
	 * @param r
	 *            Coeficiente de correlacion
	 * @param sig
	 *            Significancia
	 * @param b0
	 *            Parametro B0 de la regresion lineal
	 * @param b1
	 *            Parametro B1 de la regresion lineal
	 * @param yk
	 *            Parametro yk de la regresion lineal
	 * @param range
	 *            Valor del rango
	 * @param upi
	 *            Valor UPI 70%
	 * @param lpi
	 *            Valor LPI 70%
	 */
	public DataInfo(double r, double sig, double b0, double b1, double yk, double range, double upi, double lpi) {

		setRxy(r);
		setR2(Math.pow(r, 2));
		this.setSig(sig);
		this.setB0(b0);
		this.setB1(b1);
		this.setYk(yk);
		this.setRange(range);
		this.setUpi(upi);
		this.setLpi(lpi);
	}

	/**
	 * Coeficiente de correlacion
	 * 
	 * @return rxy
	 */
	public double getRxy() {
		return rxy;
	}

	/**
	 * Obtiene Coeficiente de correlacion elevado al cuadrado
	 * 
	 * @param rxy
	 *            Coeficiente de correlacion
	 */
	public void setRxy(double rxy) {
		this.rxy = rxy;
	}

	/**
	 * Obtiene Coeficiente de correlacion elevado al cuadrado
	 * 
	 * @return r2
	 */
	public double getR2() {
		return r2;
	}

	/**
	 * Asigna Coeficiente de correlacion elevado al cuadrado
	 * 
	 * @param r2
	 *            Coeficiente de correlacion elevado al cuadrado
	 */
	public void setR2(double r2) {
		this.r2 = r2;
	}

	/**
	 * Obtiene el valor de Significancia
	 * 
	 * @return sig
	 */
	public double getSig() {
		return sig;
	}

	/**
	 * Asigna el valor de la Significancia
	 * 
	 * @param sig
	 */
	public void setSig(double sig) {
		this.sig = sig;
	}

	/**
	 * Obtiene el valor B0 de la regresion lineal
	 * 
	 * @return Parametro B0 de la regresion lineal
	 */
	public double getB0() {
		return b0;
	}

	/**
	 * Obtiene el valor B0 de la regresion lineal
	 * 
	 * @param b0
	 *            Parametro B0 de la regresion lineal
	 */
	public void setB0(double b0) {
		this.b0 = b0;
	}

	/**
	 * Obtiene el valor B1 de la regresion lineal
	 * 
	 * @return Parametro B1 de la regresion lineal
	 */
	public double getB1() {
		return b1;
	}

	/**
	 * Obtiene el valor B1 de la regresion lineal
	 * 
	 * @param b1
	 *            Parametro B1 de la regresion lineal
	 */
	public void setB1(double b1) {
		this.b1 = b1;
	}

	/**
	 * Obtiene el Parametro yk de la regresion lineal
	 * 
	 * @return Parametro yk de la regresion lineal
	 */
	public double getYk() {
		return yk;
	}

	/**
	 * Asigna el Parametro yk de la regresion lineal
	 * 
	 * @param yk
	 *            Parametro yk de la regresion lineal
	 */
	public void setYk(double yk) {
		this.yk = yk;
	}

	/**
	 * Obtiene el valor del rango
	 * 
	 * @return Rango
	 */
	public double getRange() {
		return range;
	}

	/**
	 * Asigna el valor del rango
	 * 
	 * @param range
	 */
	public void setRange(double range) {
		this.range = range;
	}

	/**
	 * Obtiene Valor UPI 70%
	 * 
	 * @return Valor UPI 70%
	 */
	public double getUpi() {
		return upi;
	}

	/**
	 * Asigna Valor UPI 70%
	 * 
	 * @param upi
	 *            Valor UPI 70%
	 */
	public void setUpi(double upi) {
		this.upi = upi;
	}

	/**
	 * Obtiene Valor LPI 70%
	 * 
	 * @return Valor LPI 70%
	 */
	public double getLpi() {
		return lpi;
	}

	/**
	 * Asigna Valor LPI 70%
	 * 
	 * @param lpi
	 *            Valor LPI 70%
	 */
	public void setLpi(double lpi) {
		this.lpi = lpi;
	}

}
