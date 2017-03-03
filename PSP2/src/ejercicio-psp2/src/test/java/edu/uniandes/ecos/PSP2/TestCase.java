package edu.uniandes.ecos.PSP2;

import java.io.IOException;
import java.nio.file.Path;
import org.junit.Assert;
import org.junit.Test;

import edu.uniandes.ecos.PSP2.App.Controller;
import edu.uniandes.ecos.PSP2.Business.FileReader;
import edu.uniandes.ecos.PSP2.Business.Regression;
import edu.uniandes.ecos.PSP2.Entities.DataInfo;
import edu.uniandes.ecos.PSP2.Interfaces.IController;

public class TestCase {

	private final String FILE_TEST1 = "Test1/TestData.csv";

	private IController controller;

	public TestCase() {
		controller = new Controller(null);
	}

	@Test
	public void Test1() {
		try {
			DataInfo data = controller.execute(FILE_TEST1);
			Assert.assertNotNull("", data);
		} catch (Exception e) {
			Assert.fail("Test Fail");
		}

	}

}
