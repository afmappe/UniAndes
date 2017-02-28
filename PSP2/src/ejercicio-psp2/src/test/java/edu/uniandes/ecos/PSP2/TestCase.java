package edu.uniandes.ecos.PSP2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Test;
import edu.uniandes.ecos.PSP2.Entities.DataInfo;

public class TestCase {

	private final String FILE_TEST1 = "Test1/TestData.csv";
	private final int LOC = 386;
	private FileReader fileReader;
	private Regression regression;

	public TestCase() {
		fileReader = new FileReader();
		regression = new Regression();
	}

	@Test
	public void Test1() {
		try {
			DataInfo data = execute(FILE_TEST1);
			Assert.assertNotNull("", data);
		} catch (Exception e) {
			Assert.fail("Test Fail");
		}

	}

	private DataInfo execute(String fileName) throws IOException {
		Path filePath = getResourcePath(fileName);
		String content = fileReader.FileToString(filePath);
		DataInfo data = processData(content);
		return data;
	}

	private DataInfo processData(String data) {

		DataInfo result = null;

		try {
			String[] lines = data.split(System.getProperty("line.separator"));

			int count = lines.length - 1;
			double[] x = new double[count];
			double[] y = new double[count];

			for (int i = 1; i < count + 1; i++) {
				String[] line = lines[i].split(";");
				x[i - 1] = Double.parseDouble(line[0]);
				y[i - 1] = Double.parseDouble(line[1]);
			}
			result = regression.calculateEstimate(x, y, LOC);
		} catch (Exception e) {

		}

		return result;
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
