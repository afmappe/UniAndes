package edu.uniandes.ecos.PSP2.App;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import edu.uniandes.ecos.PSP2.Business.PspData;
import edu.uniandes.ecos.PSP2.Entities.DataInfo;

public class TestCase {

	private final double PRECISION = 0.01;

	@Test
	public void test1() {

		double loc = 386;

		double[] xi = new double[] { 130, 650, 99, 150, 128, 302, 95, 945, 368, 961 };
		double[] yi = new double[] { 186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601 };

		PspData t = new PspData();
		DataInfo data = t.calculate(xi, yi, loc);

		assertEquals("Value does not match", 0.954496574, data.getRxy(), PRECISION);
		assertEquals("Value does not match", 0.91106371, data.getR2(), PRECISION);
		assertEquals("Value does not match", 1.77517E-05, data.getSig(), PRECISION);
		assertEquals("Value does not match", -22.55253275, data.getB0(), PRECISION);
		assertEquals("Value does not match", 1.727932426, data.getB1(), PRECISION);
		assertEquals("Value does not match", 644.4293838, data.getYk(), PRECISION);
		assertEquals("Value does not match", 230.0017197, data.getRange(), PRECISION);
		assertEquals("Value does not match", 874.4311035, data.getUpi(), PRECISION);
		assertEquals("Value does not match", 414.427664, data.getLpi(), PRECISION);
	}

	@Test
	public void test2() {

		double loc = 386;

		double[] xi = new double[] { 130, 650, 99, 150, 128, 302, 95, 945, 368, 961 };
		double[] yi = new double[] { 15.0, 69.9, 6.5, 22.4, 28.4, 65.9, 19.4, 198.7, 38.8, 138.2 };

		PspData t = new PspData();
		DataInfo data = t.calculate(xi, yi, loc);

		assertEquals("Value does not match", 0.933306898, data.getRxy(), PRECISION);
		assertEquals("Value does not match", 0.871061766, data.getR2(), PRECISION);
		assertEquals("Value does not match", 7.98203E-05, data.getSig(), PRECISION);
		assertEquals("Value does not match", -4.038881575, data.getB0(), PRECISION);
		assertEquals("Value does not match", 0.16812665, data.getB1(), PRECISION);
		assertEquals("Value does not match", 60.85800528, data.getYk(), PRECISION);
		assertEquals("Value does not match", 27.55764748, data.getRange(), PRECISION);
		assertEquals("Value does not match", 88.41565276, data.getUpi(), PRECISION);
		assertEquals("Value does not match", 33.3003578, data.getLpi(), PRECISION);
	}

	@Test
	public void test3() {

		double loc = 224;

		double[] xi = new double[] { 209, 123, 125, 100 };
		double[] yi = new double[] { 167, 86, 126, 52 };

		PspData t = new PspData();
		DataInfo data = t.calculate(xi, yi, loc);

		assertEquals("Value does not match", 0.8979242324301161, data.getRxy(), PRECISION);
		assertEquals("Value does not match", 0.8062679271852131, data.getR2(), PRECISION);
		assertEquals("Value does not match", 0.10207579829085134, data.getSig(), PRECISION);
		assertEquals("Value does not match", -22.210250627478075, data.getB0(), PRECISION);
		assertEquals("Value does not match", 0.9332872576479575, data.getB1(), PRECISION);
		assertEquals("Value does not match", 186.84609508566442, data.getYk(), PRECISION);
		assertEquals("Value does not match", 56.3188007730651, data.getRange(), PRECISION);
		assertEquals("Value does not match", 243.16489585872952, data.getUpi(), PRECISION);
		assertEquals("Value does not match", 130.5272943125993, data.getLpi(), PRECISION);
	}

	@Test
	public void test4() {

		double loc = 224;

		double[] xi = new double[] { 209, 123, 125, 100 };
		double[] yi = new double[] { 5.5, 3.4, 3.5, 2.7 };

		PspData t = new PspData();
		DataInfo data = t.calculate(xi, yi, loc);

		assertEquals("Value does not match", 0.9980837101947989, data.getRxy(), PRECISION);
		assertEquals("Value does not match", 0.9961710925562154, data.getR2(), PRECISION);
		assertEquals("Value does not match", 0.008057285159726701, data.getSig(), PRECISION);
		assertEquals("Value does not match", 0.2794405441780925, data.getB0(), PRECISION);
		assertEquals("Value does not match", 0.025102760903568454, data.getB1(), PRECISION);
		assertEquals("Value does not match", 5.902458986577427, data.getYk(), PRECISION);
		assertEquals("Value does not match", 0.19158828414870535, data.getRange(), PRECISION);
		assertEquals("Value does not match", 6.094047270726133, data.getUpi(), PRECISION);
		assertEquals("Value does not match", 5.710870702428721, data.getLpi(), PRECISION);
	}

}
