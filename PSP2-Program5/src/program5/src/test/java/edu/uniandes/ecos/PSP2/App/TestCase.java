package edu.uniandes.ecos.PSP2.App;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Test;

import edu.uniandes.ecos.PSP2.Business.FileReader;
import edu.uniandes.ecos.PSP2.Business.Gamma;
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
	public void readFile() {
		String fileName = "Test1/TestData.csv";
		Path path = FileReader.getResourcePath(fileName);
		assertNotNull("Path is empty", fileName);

		try {
			String content = FileReader.fileToString(path);
			assertNotNull("String is empty", content);
		} catch (IOException e) {
			Assert.fail("Test Fail");
		}

	}

	@Test
	public void fileValues() {
		try {

			Path path = FileReader.getResourcePath(FILE_TEST1);
			
		} catch (Exception e) {
			Assert.fail("Test Fail");
		}

	}
}
