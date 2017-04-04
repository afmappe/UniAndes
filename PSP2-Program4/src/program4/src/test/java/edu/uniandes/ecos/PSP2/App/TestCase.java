package edu.uniandes.ecos.PSP2.App;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Test;

import edu.uniandes.ecos.PSP2.Business.FileReader;
import edu.uniandes.ecos.PSP2.Business.RelativeSize;
import edu.uniandes.ecos.PSP2.Entities.RelativeSizeInfo;
import edu.uniandes.ecos.PSP2.Interfaces.IController;

public class TestCase {

	private final String FILE_TEST1 = "Test1/TestData.csv";

	private final double PRECISION = 0.01;

	private IController controller;

	public TestCase() {
		controller = new Controller(null);
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
	public void arrayValues() {
		RelativeSize r = new RelativeSize();
		double[] array = new double[] { 6.00, 6.00, 8.33, 10.33, 12.33, 16.40, 20.50, 21.75, 22.25, 23.00, 28.33, 29.00,
				55.80 };
		try {
			RelativeSizeInfo data = r.Calculate(array);
			assertNotNull("Is null", data);
			assertEquals("Value does not match", 4.3953, data.getVerySmall(), PRECISION);
			assertEquals("Value does not match", 8.5081, data.getSmall(), PRECISION);
			assertEquals("Value does not match", 16.4696, data.getMedium(), PRECISION);
			assertEquals("Value does not match", 31.8811, data.getLarge(), PRECISION);
			assertEquals("Value does not match", 61.7137, data.getVeryLarge(), PRECISION);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test Fail");
		}
	}

	@Test
	public void fileValues() {
		try {

			Path path = FileReader.getResourcePath(FILE_TEST1);
			RelativeSizeInfo data = controller.execute(path.toString());
			assertNotNull("Is null", data);
			assertEquals("Value does not match", 4.3953, data.getVerySmall(), PRECISION);
			assertEquals("Value does not match", 8.5081, data.getSmall(), PRECISION);
			assertEquals("Value does not match", 16.4696, data.getMedium(), PRECISION);
			assertEquals("Value does not match", 31.8811, data.getLarge(), PRECISION);
			assertEquals("Value does not match", 61.7137, data.getVeryLarge(), PRECISION);

		} catch (Exception e) {
			Assert.fail("Test Fail");
		}

	}

}
