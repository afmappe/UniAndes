package edu.uniandes.ecos.PSP2.Business;

import java.util.Arrays;
import java.util.stream.IntStream;

import edu.uniandes.ecos.PSP2.Entities.RelationDataInfo;

public class Regression {

	public RelationDataInfo calculateEstimate(double[] xVals, double[] yVals, double xk) {
		RelationDataInfo result = calculateLinearRegression(xVals, yVals);
		result.setYk(xk);
		return result;
	}

	public RelationDataInfo calculateLinearRegression(double[] xVals, double[] yVals) {

		RelationDataInfo result = null;
		if (xVals != null & yVals != null & xVals.length == yVals.length) {
			int count = xVals.length;
			double xSum = Arrays.stream(xVals).map(x -> x).sum();
			double ySum = Arrays.stream(yVals).map(y -> y).sum();
			double xPowSum = Arrays.stream(xVals).map(x -> Math.pow(x, 2)).sum();
			double yPowSum = Arrays.stream(yVals).map(y -> Math.pow(y, 2)).sum();
			double xAvg = xSum / count;
			double yAvg = ySum / count;

			double[] xy = new double[count];
			IntStream.range(0, count).forEach(i -> xy[i] = xVals[i] * yVals[i]);
			double xySum = Arrays.stream(xy).map(t -> t).sum();

			double b1 = (xySum - (count * xAvg * yAvg)) / (xPowSum - (count * Math.pow(xAvg, 2)));
			double b0 = yAvg - b1 * xAvg;

			double rxy = (count * xySum - (xSum * ySum))
					/ Math.sqrt((((count * xPowSum - Math.pow(xSum, 2)) * (count * yPowSum - Math.pow(ySum, 2)))));

			result = new RelationDataInfo(b0, b1, xAvg, yAvg, rxy);
		}
		return result;
	}
}
