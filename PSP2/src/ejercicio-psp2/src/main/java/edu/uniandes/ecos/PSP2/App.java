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

		CsvFileReader file = new CsvFileReader();
		try {
			file.Test("C:\\Users\\afmap\\Desktop\\TestCSV.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
