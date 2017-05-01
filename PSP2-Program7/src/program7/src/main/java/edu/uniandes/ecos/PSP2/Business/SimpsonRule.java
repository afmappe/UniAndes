package edu.uniandes.ecos.PSP2.Business;

import java.util.Arrays;

import edu.uniandes.ecos.PSP2.Entities.SimpsonRuleInfo;

/**
 * Permite calcular numéricamente la integral de una función aplicando la regla
 * de Simpson.
 * 
 * @author af.mape
 *
 */
public class SimpsonRule {

	/**
	 * límite hasta el cual se va a calcular la función
	 */
	private double x;

	/**
	 * Grados de libertad para la función
	 */
	private double dof;

	/**
	 * Número inicial de segmentos, Restricción debe ser un número par
	 */
	private int numSeg;

	/**
	 * Error aceptable
	 */
	private double error = 0.000001;

	/**
	 * La anchura del segmento x/ numSeg
	 */
	private double w;

	/**
	 * Multiplicadores de la función
	 */
	private double[] multiplier;

	/**
	 * Obtiene le valor de x
	 * 
	 * @return x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Obtiene le valor del grado de libertad de la funcion
	 * 
	 * @return dof
	 */
	public double getDof() {
		return dof;
	}

	/**
	 * Obtiene le valor del peso de la funcion
	 * 
	 * @return x / numSeg
	 */
	public double getW() {
		return x / numSeg;
	}

	public SimpsonRule(double x, double dof) {
		this.x = x;
		this.dof = dof;
	}

	/**
	 * Ejecuta el cálculo de la regla de Simpson
	 * 
	 * @return valor de la integral
	 */
	public SimpsonRuleInfo calculate() {

		SimpsonRuleInfo result = new SimpsonRuleInfo();
		result.setDof(dof);
		result.setX(x);

		// double value1 = internalCalculate(20);
		double value2 = internalCalculate(30);
		// if ((value1 - value2) < error) {

		result.setValue(value2);
		// }

		return result;
	}

	/**
	 * Ejecuta el cálculo de la regla de Simpson
	 * 
	 * @param segments
	 *            razon de cambio de x
	 * @return valor de la integral
	 */
	private double internalCalculate(int segments) {

		numSeg = segments;
		double[] xi = generateXi();
		double[] multiplier = generateMultiplier();
		double[] t = calcFirstPart(xi);
		double function = calcSecondPart();
		double[] fxi = calculateFx(t, function);

		double result = calculateRule(fxi, multiplier);
		return result;
	}

	/**
	 * Genera el arreglo con los valores de X desde 0 a Xi
	 * 
	 * @return Arreglo Xi
	 */
	private double[] generateXi() {
		double[] xi = new double[numSeg + 1];
		double w = getW();
		xi[0] = 0;

		for (int i = 1; i < xi.length; i++) {
			xi[i] += xi[i - 1] + w;
		}

		return xi;
	}

	/**
	 * Genera el arreglo con los valores de los multiplicadores de la funcion de
	 * Simpson
	 * 
	 * @return Arreglo de multiplicadores
	 */
	private double[] generateMultiplier() {
		double[] result = new double[numSeg + 1];

		for (int i = 0; i < numSeg; i += 2) {
			result[i] = 2;
			result[i + 1] = 4;
		}

		result[0] = 1;
		result[numSeg] = 1;

		return result;
	}

	/**
	 * Calcula el primer termino de la ecuacion
	 * 
	 * @param xi
	 *            Arreglo de valores de X
	 * @return Primer termino de la ecuacion
	 */
	private double[] calcFirstPart(double[] xi) {
		double[] result = new double[xi.length];

		double exp = (dof + 1) / 2;
		for (int i = 0; i < xi.length; i++) {
			double temp = 1 + (Math.pow(xi[i], 2)) / dof;
			result[i] = Math.pow(temp, -exp);
		}
		return result;
	}

	/**
	 * Calcula el primer segundo termino de la ecuacion
	 * 
	 * @return Segundo termino de la ecuacion
	 */
	private double calcSecondPart() {
		double result = 0;
		double t = Gamma.gamma(((dof + 1) / 2));
		double t1 = Math.pow((dof * Math.PI), 0.5);
		double t3 = Gamma.gamma((dof / 2));
		result = t / (t1 * t3);
		return result;
	}

	/**
	 * Calula los valores de F(x) para cada i
	 * 
	 * @param t
	 *            primer termino de la ecuacion
	 * @param t2
	 *            segundo termino de la ecuacion
	 * @return valores de F(x)
	 */
	private double[] calculateFx(double[] t, double t2) {
		double[] result = new double[t.length];

		for (int i = 0; i < t.length; i++) {
			result[i] = t[i] * t2;
		}

		return result;
	}

	/**
	 * Mutiplica W/3 por cada mutiplicador por cada F(xi) para evaluar la regla
	 * de simpson
	 * 
	 * @param fxi
	 *            los valore de x evaluados
	 * @param multiplier
	 *            arreglo de multiplicadores
	 * @return Valor de la regla de simpson
	 */
	private double calculateRule(double[] fxi, double[] multiplier) {

		double[] temp = new double[fxi.length];
		double factor = getW() / 3;

		for (int i = 0; i < fxi.length; i++) {
			temp[i] = factor * multiplier[i] * fxi[i];
		}
		double result = Arrays.stream(temp).map(x -> x).sum();
		return result;
	}

}
