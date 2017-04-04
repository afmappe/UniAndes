package edu.uniandes.ecos.PSP2.Entities;

/**
 * 
 * @author af.mape
 *
 */
public class SimpsonRuleInfo {

	/**
	 * Valor de x
	 */
	private double x;

	/**
	 * Valor del grado de libertad
	 */
	private double dof;

	/**
	 * Valor al evaluar la regla
	 */
	private double value;

	/**
	 * Obtine el valor de x
	 * 
	 * @return x valor de x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Asigna el valor a x
	 * 
	 * @param x
	 *            valor de x
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Obtiene el valor del grado de libertad
	 * 
	 * @return Valor de dof
	 */
	public double getDof() {
		return dof;
	}

	/**
	 * Asigna el valor del grado de libertad
	 * 
	 * @param dof
	 */
	public void setDof(double dof) {
		this.dof = dof;
	}

	/**
	 * Obtiene el valor del resultado
	 * 
	 * @return value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Asigna el valor del resultado
	 * 
	 * @param value
	 *            valor del resultado
	 */
	public void setValue(double value) {
		this.value = value;
	}
}
