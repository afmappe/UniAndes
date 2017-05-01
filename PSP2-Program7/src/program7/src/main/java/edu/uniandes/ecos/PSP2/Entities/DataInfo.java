package edu.uniandes.ecos.PSP2.Entities;

/**
 * 
 * @author af.mape
 *
 */
public class DataInfo {

	/**
	 * Coeficiente de correlacion
	 */
	private double rxy;

	/**
	 * Coeficiente de correlacion al cuadrado
	 */
	private double r2;

	/**
	 * 
	 */
	private double sig;

	/**
	 * 
	 */
	private double b0;

	/**
	 * 
	 */
	private double b1;

	/**
	 * 
	 */
	private double yk;

	/**
	 * 
	 */
	private double range;

	/**
	 * 
	 */
	private double upi;

	/**
	 * 
	 */
	private double lpi;

	/**
	 * 
	 * @param r
	 * @param sig
	 * @param b0
	 * @param b1
	 * @param yk
	 * @param range
	 * @param upi
	 * @param lpi
	 */
	public DataInfo(double r, double sig, double b0, double b1, double yk, double range, double upi, double lpi) {

		setRxy(r);
		setR2(Math.pow(r, 2));
		this.setSig(sig);
		this.setB0(b0);
		this.setB1(b1);
		this.setYk(yk);
		this.setRange(range);
		this.setUpi(upi);
		this.setLpi(lpi);
	}

	/**
	 * 
	 * @return
	 */
	public double getRxy() {
		return rxy;
	}

	/**
	 * 
	 * @param rxy
	 */
	public void setRxy(double rxy) {
		this.rxy = rxy;
	}

	/**
	 * 
	 * @return
	 */
	public double getR2() {
		return r2;
	}

	/**
	 * 
	 * @param r2
	 */
	public void setR2(double r2) {
		this.r2 = r2;
	}

	/**
	 * 
	 * @return
	 */
	public double getSig() {
		return sig;
	}

	/**
	 * 
	 * @param sig
	 */
	public void setSig(double sig) {
		this.sig = sig;
	}

	/**
	 * 
	 * @return
	 */
	public double getB0() {
		return b0;
	}

	/**
	 * 
	 * @param b0
	 */
	public void setB0(double b0) {
		this.b0 = b0;
	}

	/**
	 * 
	 * @return
	 */
	public double getB1() {
		return b1;
	}

	/**
	 * 
	 * @param b1
	 */
	public void setB1(double b1) {
		this.b1 = b1;
	}

	/**
	 * 
	 * @return
	 */
	public double getYk() {
		return yk;
	}

	/**
	 * 
	 * @param yk
	 */
	public void setYk(double yk) {
		this.yk = yk;
	}

	/**
	 * 
	 * @return
	 */
	public double getRange() {
		return range;
	}

	/**
	 * 
	 * @param range
	 */
	public void setRange(double range) {
		this.range = range;
	}

	/**
	 * 
	 * @return
	 */
	public double getUpi() {
		return upi;
	}

	/**
	 * 
	 * @param upi
	 */
	public void setUpi(double upi) {
		this.upi = upi;
	}

	/**
	 * 
	 * @return
	 */
	public double getLpi() {
		return lpi;
	}

	/**
	 * 
	 * @param lpi
	 */
	public void setLpi(double lpi) {
		this.lpi = lpi;
	}

}
