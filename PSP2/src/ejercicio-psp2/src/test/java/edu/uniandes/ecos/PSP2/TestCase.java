package edu.uniandes.ecos.PSP2;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import edu.uniandes.ecos.PSP2.App.Controller;
import edu.uniandes.ecos.PSP2.Business.FileReader;
import edu.uniandes.ecos.PSP2.Business.Regression;
import edu.uniandes.ecos.PSP2.Entities.DataInfo;
import edu.uniandes.ecos.PSP2.Interfaces.IController;

public class TestCase {

	private final String FILE_TEST1 = "Test1/TestData.csv";
	private final String FILE_TEST2 = "Test2/TestData.csv";

	private final double PRECISION = 0.01;

	private IController controller;

	public TestCase() {
		controller = new Controller(null);
	}

	@Test
	public void readFile() {
		String fileName = "Test1/TestData.csv";
		Path path = getResourcePath(fileName);
		assertNotNull("Path is empty", fileName);

		try {
			String content = FileReader.fileToString(path);
			assertNotNull("String is empty", content);
		} catch (IOException e) {
			Assert.fail("Test Fail");
		}

	}

	@Test
	public void arrayValues() {

		double loc = 386;
		double[] x = new double[] { 163, 765, 141, 166, 137, 355, 136, 1206, 433, 1130 };
		double[] y = new double[] { 186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601 };

		Regression r = new Regression();
		DataInfo data = r.calculateEstimate(x, y, loc);

		assertNotNull("Is null", data);
		assertEquals("Value does not match", -23.92, data.getParameterB0(), PRECISION);
		assertEquals("Value does not match", 1.43097, data.getParameterB1(), PRECISION);
		assertEquals("Value does not match", 0.9631, data.getCorrelationCoefficient(), PRECISION);
		assertEquals("Value does not match", 0.9276, data.getR2(), PRECISION);
		assertEquals("Value does not match", 528.4294, data.getYk(), PRECISION);

	}

	@Test
	public void fileValues() {
		try {

			Path path = getResourcePath(FILE_TEST1);
			DataInfo data = controller.execute(path.toString());

			assertNotNull("Is null", data);
			assertEquals("Value does not match", -22.55, data.getParameterB0(), PRECISION);
			assertEquals("Value does not match", 1.7279, data.getParameterB1(), PRECISION);
			assertEquals("Value does not match", 0.9545, data.getCorrelationCoefficient(), PRECISION);
			assertEquals("Value does not match", 0.9111, data.getR2(), PRECISION);
			assertEquals("Value does not match", 644.429, data.getYk(), PRECISION);

			path = getResourcePath(FILE_TEST2);
			data = controller.execute(path.toString());

			assertNotNull("Is null", data);
			assertEquals("Value does not match", -4.039, data.getParameterB0(), PRECISION);
			assertEquals("Value does not match", 0.1681, data.getParameterB1(), PRECISION);
			assertEquals("Value does not match", 0.9333, data.getCorrelationCoefficient(), PRECISION);
			assertEquals("Value does not match", 0.8711, data.getR2(), PRECISION);
			assertEquals("Value does not match", 60.858, data.getYk(), PRECISION);

		} catch (Exception e) {
			Assert.fail("Test Fail");
		}

	}

	private Path getResourcePath(String resourceName) {
		Path path = null;
		try {
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			URL url = classLoader.getResource(resourceName);
			path = Paths.get(url.toURI());
		} catch (URISyntaxException e) {
			Assert.fail("Test Fail");
			e.printStackTrace();
		}
		return path;
	}

}
