package edu.uniandes.ecos.PSP2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		// System.out.println( "Hello World!" );
		// Scanner scanner = new Scanner(System.in);
		//
		// System.out.println( "Write Path" );
		// String path = scanner.nextLine();
		//
		//

		Temp t = new Temp();
		double[] x = { 130, 650, 99, 150, 128, 302, 95, 945, 368, 961 };
		double[] y = { 186, 699, 132, 272, 291, 331, 199, 1890, 788, 1601 };

		t.LinearRegression(x, y);
	}
}