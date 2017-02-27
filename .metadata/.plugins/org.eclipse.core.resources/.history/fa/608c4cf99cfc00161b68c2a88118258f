package edu.uniandes.ecos.PSP2;

import java.util.ArrayList;

public class Temp {
	private ArrayList<Double> x;
	private ArrayList<Double> y;
	private Double sumX;
	private Double sumY;

	public Temp() {
		x = new ArrayList<Double>();
		y = new ArrayList<Double>();
	}

	public ArrayList<Double> getX() {
		return x;
	}

	public ArrayList<Double> getY() {
		return y;
	}

	public void setX(Double t) {
		this.x.add(t);
	}

	public void setY(Double t) {
		this.y.add(t);
	}

	public Double getSumX() {
		return sumX;
	}

	public Double getSumY() {
		return sumY;
	}

	private void setSumX() {
		if (x.size() > 0) {
			for (Double num : x) {
				sumX += num;
			}
		}
	}

	private void setSumY() {
		if (y.size() > 0) {
			for (Double num : y) {
				sumY += num;
			}
		}
	}

}
