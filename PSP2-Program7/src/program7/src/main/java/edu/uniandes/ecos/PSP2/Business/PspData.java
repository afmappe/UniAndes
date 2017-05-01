package edu.uniandes.ecos.PSP2.Business;

import java.util.Arrays;
import java.util.stream.IntStream;

import edu.uniandes.ecos.PSP2.Entities.DataInfo;
import edu.uniandes.ecos.PSP2.Entities.RelationDataInfo;
import edu.uniandes.ecos.PSP2.Entities.SimpsonRuleInfo;

/**
 * Integra los cálculos de correlación, significancia, regresión lineal, métodos
 * de integración por regla de Simpson.
 * 
 * @author af.mape
 *
 */
public class PspData {

	/**
	 * Permite calcular las funciones de significancia, regresión lineal,
	 * métodos de integración por regla de Simpson. Para un conjunto de datos y
	 * un número de líneas de código
	 * 
	 * @param xi
	 *            Valores de x
	 * @param yi
	 *            Valores de y
	 * @param xk
	 *            Numero de linea de codigo
	 * @return Resumen de las operaciones
	 */
	public DataInfo calculate(double[] xi, double[] yi, double xk) {
		DataInfo result = null;

		if (xi != null && yi != null && xi.length == yi.length) {

			int n = xi.length;

			Regression reg = new Regression();
			RelationDataInfo data = reg.calculateEstimate(xi, yi, xk);

			double b0 = data.getParameterB0();
			double b1 = data.getParameterB1();
			double r = data.getCorrelationCoefficient();

			double range = calculateRange(xi, yi, xk, b0, b1, data.getxAvg(), n);
			double upi = data.getYk() + range;
			double lpi = data.getYk() - range;

			double sig = calculateSignificance(n, r);

			result = new DataInfo(r, sig, b0, b1, data.getYk(), range, upi, lpi);
		}
		return result;
	}

	/**
	 * Calcula el rango
	 * 
	 * @param xi
	 *            valores de x
	 * @param yi
	 *            valores de y
	 * @param xk
	 *            conteo de lineas de codigo
	 * @param b0
	 *            valor de Bo
	 * @param b1
	 *            Valor de B1
	 * @param xAvg
	 *            promedio de x
	 * @param n
	 *            catidad de datos
	 * @return Valor del rango
	 */
	private double calculateRange(double[] xi, double[] yi, double xk, double b0, double b1, double xAvg, int n) {
		double result = 0;

		double omega = calculateOmega(xi, yi, b0, b1, n);

		SimpsonRuleInfo t = new SearchAlgorithm().test(0.35, (n - 2));

		double xt = t.getX();

		double f = 1.0 + 1.0 / n;
		double numerator = Math.pow((xk - xAvg), 2);
		double sum = Arrays.stream(xi).map(x -> Math.pow((x - xAvg), 2)).sum();
		double num = (f + numerator / sum);
		double tp = Math.sqrt(num);

		result = xt * omega * tp;
		return result;

	}

	/**
	 * Calcula el valor de la funcion omega para el calculo del rango
	 * 
	 * @param xi
	 *            valores de x
	 * @param yi
	 *            valores de y
	 * @param b0
	 *            Valor de B0
	 * @param b1
	 *            valor de B1
	 * @param n
	 *            cantidad de datos
	 * @return valor de omega
	 */
	private double calculateOmega(double[] xi, double[] yi, double b0, double b1, int n) {
		double omega = 0;

		double[] temp = new double[n];
		IntStream.range(0, n).forEach(i -> temp[i] = Math.pow(yi[i] - b0 - b1 * xi[i], 2));
		double sum = Arrays.stream(temp).map(t -> t).sum();

		double num = 1.0 / (n - 2);
		omega = Math.sqrt(num * sum);

		return omega;
	}

	/**
	 * Calcula la significancia
	 * 
	 * @param n
	 *            cantidad de datos
	 * @param r
	 *            coeficiente de correlacion
	 * @return valor de la significancia
	 */
	private double calculateSignificance(int n, double r) {
		double result = 0;

		double t1 = Math.abs(r) * Math.sqrt(n - 2);

		double t2 = Math.sqrt((1 - Math.pow(r, 2)));

		double x = t1 / t2;

		SimpsonRule rule = new SimpsonRule(x, (n - 2));
		SimpsonRuleInfo data = rule.calculate();

		result = 1.0 - 2.0 * data.getValue();
		return result;
	}
}
