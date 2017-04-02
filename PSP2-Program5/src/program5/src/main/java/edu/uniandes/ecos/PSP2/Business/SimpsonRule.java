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
	private double error = 0.00001;

	/**
	 * La anchura del segmento x/ numSeg
	 */
	private double w;

	/**
	 * 
	 */
	private double[] multiplier;

	public double getX() {
		return x;
	}

	public double getDof() {
		return dof;
	}

	public double getW() {
		return x / numSeg;
	}

	public SimpsonRule(double x, double dof) {
		this.x = x;
		this.dof = dof;
	}

	public SimpsonRuleInfo calculate() {

		SimpsonRuleInfo result = new SimpsonRuleInfo();
		result.setDof(dof);
		result.setX(x);

		double value1 = internalCalculate(10);
		double value2 = internalCalculate(20);
		if ((value1 - value2) < error) {

			result.setValue(value2);
		}

		return result;
	}

	private double internalCalculate(int segments) {

		numSeg = segments;
		double[] xi = generateXi();
		double[] multiplier = generateMultiplier();
		double[] t = calcFirst(xi);
		double function = calcSecond();
		double[] fxi = calculateFx(t, function);
		double[] r = calculateRule(fxi, multiplier);

		double result = Arrays.stream(r).map(x -> x).sum();
		return result;
	}

	private double[] generateXi() {
		double[] xi = new double[numSeg + 1];
		double w = getW();
		xi[0] = 0;

		for (int i = 1; i < xi.length; i++) {
			xi[i] += xi[i - 1] + w;
		}

		return xi;
	}

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

	private double[] calcFirst(double[] xi) {
		double[] result = new double[xi.length];

		double exp = (dof + 1) / 2;
		for (int i = 0; i < xi.length; i++) {
			double temp = 1 + (Math.pow(xi[i], 2)) / dof;
			result[i] = Math.pow(temp, -exp);
		}
		return result;
	}

	private double calcSecond() {
		double result = 0;
		double t = Gamma.gamma(((dof + 1) / 2));
		double t1 = Math.pow((dof * Math.PI), 0.5);
		double t3 = Gamma.gamma((dof / 2));
		result = t / (t1 * t3);
		return result;
	}

	private double[] calculateFx(double[] t, double function) {
		double[] result = new double[t.length];

		for (int i = 0; i < t.length; i++) {
			result[i] = t[i] * function;
		}

		return result;
	}

	private double[] calculateRule(double[] fxi, double[] multiplier) {
		double[] result = new double[fxi.length];
		double factor = getW() / 3;

		for (int i = 0; i < fxi.length; i++) {
			result[i] = factor * multiplier[i] * fxi[i];
		}

		return result;
	}

}
