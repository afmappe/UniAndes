package edu.uniandes.ecos.PSP2.Business;

import java.util.Arrays;

import edu.uniandes.ecos.PSP2.Entities.RelativeSizeInfo;

/**
 * Calcula el tamaño relativo basado en la desviacion estandar
 * 
 * @author af.mape
 *
 */
public class RelativeSize {

	/**
	 * Calcula el tamaño relativo
	 * 
	 * @param data
	 *            arreglo con los valores
	 * @return informacion con los valores del tamaño relativo
	 * @throws Exception
	 */
	public RelativeSizeInfo Calculate(double[] data) throws Exception {

		RelativeSizeInfo result = null;
		if (data != null & data.length > 0) {
			int count = data.length;

			double[] ln = Arrays.stream(data).map(x -> Math.log(x)).toArray();
			double lnSum = Arrays.stream(ln).map(x -> x).sum();
			double avg = lnSum / count;
			double[] lnAvg2 = Arrays.stream(ln).map(x -> Math.pow((x - avg), 2)).toArray();
			double lnAvgSum = Arrays.stream(lnAvg2).map(x -> x).sum();
			double o2 = lnAvgSum / (count - 1);
			double o = Math.sqrt(o2);

			result = new RelativeSizeInfo(data, avg, o);

		} else {
			throw new Exception("data is null or empty");
		}

		return result;
	}

}
