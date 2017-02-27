package edu.uniandes.ecos.PSP2;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Temp {
	private int count;
	private double xSum;
	private double ySum;
	private double xAvg;
	private double yAvg;
	private double xPowSum;
	private double yPowSum;
	private double xySum;
	private double b0;
	private double b1;

	public void LinearRegression(double[] xVals, double[] yVals) {
		if (xVals != null & yVals != null & xVals.length == yVals.length) {
			count = xVals.length;
			xSum = Arrays.stream(xVals).map(x -> x).sum();
			ySum = Arrays.stream(yVals).map(y -> y).sum();
			xPowSum = Arrays.stream(xVals).map(x -> Math.pow(x, 2)).sum();
			yPowSum = Arrays.stream(yVals).map(y -> Math.pow(y, 2)).sum();
			xAvg = xSum / count;
			yAvg = ySum / count;

			double[] xy = new double[count];
			IntStream.range(0, count).forEach(i -> xy[i] = xVals[i] * yVals[i]);
			xySum = Arrays.stream(xy).map(t -> t).sum();

			b1 = (xySum - (count * xAvg * yAvg)) / (xPowSum - (count * Math.pow(xAvg, 2)));
			b0 = yAvg - b1 * xAvg;

			double rxy = (count * xySum - (xSum * ySum))
					/ Math.sqrt((((count * xPowSum - Math.pow(xSum, 2)) * (count * yPowSum - Math.pow(ySum, 2)))));

			double r2 = Math.pow(rxy, 2);

		}

	}

	public double Second(double b0, double b1, double xk) {
		return b0 + b1 * xk;
	}
}