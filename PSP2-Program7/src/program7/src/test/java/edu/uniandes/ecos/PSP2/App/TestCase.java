package edu.uniandes.ecos.PSP2.App;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

import edu.uniandes.ecos.PSP2.Business.Gamma;
import edu.uniandes.ecos.PSP2.Business.Regression;
import edu.uniandes.ecos.PSP2.Business.SearchAlgorithm;
import edu.uniandes.ecos.PSP2.Business.SimpsonRule;
import edu.uniandes.ecos.PSP2.Entities.DataInfo;
import edu.uniandes.ecos.PSP2.Entities.RelationDataInfo;
import edu.uniandes.ecos.PSP2.Entities.SimpsonRuleInfo;
import edu.uniandes.ecos.PSP2.Interfaces.IController;

public class TestCase {

	@Test
	public void gammaTest() {

		double loc = 386;

		double[] xi = new double[] { 130, 650, 99, 150, 128, 302, 95, 945, 368, 961 };
		double[] yi = new double[] { 186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601 };

		calculate(xi, yi, loc);

	}

	private DataInfo calculate(double[] xi, double[] yi, double xk) {
		DataInfo result = null;

		if (xi != null && yi != null && xi.length == yi.length) {

			int n = xi.length;

			Regression reg = new Regression();
			RelationDataInfo data = reg.calculateEstimate(xi, yi, xk);

			double b0 = data.getParameterB0();
			double b1 = data.getParameterB1();
			double r = data.getCorrelationCoefficient();

			double range = CalculateRange(xi, yi, xk, b0, b1, data.getxAvg(), n);
			double upi = data.getYk() + range;
			double lpi = data.getYk() - range;

			double sig = CalculateSignificance(n, r);

			result = new DataInfo(r, sig, b0, b1, data.getYk(), range, upi, lpi);
		}
		return result;
	}

	private double CalculateRange(double[] xi, double[] yi, double xk, double b0, double b1, double xAvg, int n) {
		double result = 0;

		double omega = CalculateOmega(xi, yi, b0, b1, n);

		SimpsonRuleInfo t = new SearchAlgorithm().test(0.35, (n - 2));

		double xt = t.getX();
		double tp = Temp(n, xi, xk, xAvg);

		result = xt * omega * tp;
		return result;

	}

	private double CalculateOmega(double[] xi, double[] yi, double b0, double b1, int n) {
		double omega = 0;

		double[] temp = new double[n];
		IntStream.range(0, n).forEach(i -> temp[i] = Math.pow(yi[i] - b0 - b1 * xi[i], 2));
		double sum = Arrays.stream(temp).map(t -> t).sum();

		double num = 1.0 / (n - 2);
		omega = Math.sqrt(num * sum);

		return omega;
	}

	private double Temp(int n, double[] xi, double xk, double xavg) {
		double result = 0;

		double f = 1.0 + 1.0 / n;
		double numerator = Math.pow((xk - xavg), 2);
		double sum = Arrays.stream(xi).map(x -> Math.pow((x - xavg), 2)).sum();
		double num = (f + numerator / sum);
		result = Math.sqrt(num);

		return result;
	}

	private double CalculateSignificance(int n, double r) {
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
