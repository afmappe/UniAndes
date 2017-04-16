package edu.uniandes.ecos.PSP2.App;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Test;

import edu.uniandes.ecos.PSP2.Business.Gamma;
import edu.uniandes.ecos.PSP2.Business.SearchAlgorithm;
import edu.uniandes.ecos.PSP2.Business.SimpsonRule;
import edu.uniandes.ecos.PSP2.Entities.SimpsonRuleInfo;
import edu.uniandes.ecos.PSP2.Interfaces.IController;

public class TestCase {

	private final String FILE_TEST1 = "Test1/TestData.csv";

	private final double PRECISION = 0.01;

	private IController controller;

	public TestCase() {
		controller = new Controller(null);
	}

	public enum Operation {
		SUM, REST;
	}

	@Test
	public void gammaTest() {

		double t = Gamma.gamma(5);
		double t1 = Gamma.gamma(5.5);
		double t2 = Gamma.gamma(15.5);
		assertEquals("Value does not match", 24, t, PRECISION);
		assertEquals("Value does not match", 52.3427, t1, PRECISION);
		assertEquals("Value does not match", 3.3483860980090125E11, t2, PRECISION);
	}

	@Test
	public void directValues() {

		SimpsonRule sr = new SimpsonRule(1.1, 9);
		SimpsonRule sr1 = new SimpsonRule(1.1812, 10);
		SimpsonRule sr2 = new SimpsonRule(2.750, 30);

		SimpsonRuleInfo r = sr.calculate();
		SimpsonRuleInfo r1 = sr1.calculate();
		SimpsonRuleInfo r2 = sr2.calculate();
		assertEquals("Value does not match", 0.35006, r.getValue(), PRECISION);
		assertEquals("Value does not match", 0.36757, r1.getValue(), PRECISION);
		assertEquals("Value does not match", 0.49500, r2.getValue(), PRECISION);

	}

	@Test
	public void exercise6() {
		SearchAlgorithm search = new SearchAlgorithm();
		
		SimpsonRuleInfo result = search.test(0.2, 6);
		assertEquals("Value does not match", 0.55338, round(result.getX(), 5), 0.0001);

		result = search.test(0.45, 15);
		assertEquals("Value does not match", 1.75305, round(result.getX(), 5), 0.0001);

		result = search.test(0.495, 4);
		assertEquals("Value does not match", 4.60409, round(result.getX(), 5), 0.001);

	}

	public double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}
}
