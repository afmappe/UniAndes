package edu.uniandes.ecos.PSP2.Business;

import edu.uniandes.ecos.PSP2.Entities.OperationCode;
import edu.uniandes.ecos.PSP2.Entities.SimpsonRuleInfo;

/**
 * Busca el valor de X para una integral definida
 * 
 * @author af.mape
 *
 */
public class SearchAlgorithm {

	/**
	 * Busca el valor de X dado un p y un dof
	 * 
	 * @param p
	 *            valor de la integral
	 * @param dof
	 *            grado de libertad
	 * @return Valor de x para un p
	 */
	public SimpsonRuleInfo test(double p, double dof) {
		SimpsonRuleInfo result = null;

		double error = 0.00000000001;
		SimpsonRule sr = new SimpsonRule(p, dof);
		SimpsonRuleInfo r = sr.calculate();
		result = findValue(r, p, error, 0.5, null, null);

		return result;
	}

	/**
	 * Busca recursivamente el valor de x
	 * 
	 * @param sr
	 *            valor de regla de simpson
	 * @param pExpected
	 *            valor esperado
	 * @param error
	 *            valor del error
	 * @param d
	 *            ajuste de la funcion
	 * @param before
	 *            operacion anterior
	 * @param after
	 *            proxima operacion
	 * @return valor de la regla de simpson
	 */
	private SimpsonRuleInfo findValue(SimpsonRuleInfo sr, double pExpected, double error, double d,
			OperationCode before, OperationCode after) {

		SimpsonRuleInfo result = sr;

		double x = result.getX();
		double pCurrent = result.getValue();

		if (Math.abs(pExpected - pCurrent) > error) {
			if (pCurrent > pExpected) {
				x -= d;
				after = OperationCode.REST;
			} else {
				x += d;
				after = OperationCode.SUM;
			}

			SimpsonRule rule = new SimpsonRule(x, sr.getDof());
			result = rule.calculate();
			pCurrent = result.getValue();

			if (Math.abs(pExpected - pCurrent) > error) {

				before = after;
				if (pCurrent > pExpected) {
					after = OperationCode.REST;
				} else {
					after = OperationCode.SUM;
				}

				if (before != after) {
					d = d / 2;
				}

				result = findValue(result, pExpected, error, d, before, after);
			}
		}
		return result;
	}

}
