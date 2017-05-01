package edu.uniandes.ecos.PSP2.Entities;

public class DataInfo {

	private double rxy;

	private double r2;

	private double sig;

	private double b0;

	private double b1;

	private double yk;

	private double range;

	private double upi;

	private double lpi;

	public DataInfo(double r, double sig, double b0, double b1, double yk, double range, double upi, double lpi) {

		rxy = r;
		r2 = Math.pow(r, 2);
		this.sig = sig;
		this.b0 = b0;
		this.b1 = b1;
		this.yk = yk;
		this.range = range;
		this.upi = upi;
		this.lpi = lpi;
	}

}
