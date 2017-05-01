package edu.uniandes.ecos.PSP2.App;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import edu.uniandes.ecos.PSP2.Business.PspData;
import edu.uniandes.ecos.PSP2.Entities.DataInfo;

public class TestCase {

	@Test
	public void gammaTest() {

		double loc = 386;

		double[] xi = new double[] { 130, 650, 99, 150, 128, 302, 95, 945, 368, 961 };
		double[] yi = new double[] { 186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601 };

		PspData t = new PspData();
		DataInfo result = t.calculate(xi, yi, loc);
	}

}
