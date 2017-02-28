package edu.uniandes.ecos.PSP2;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

	}

	public static String getFilePath() {
		Scanner scanner = new Scanner(System.in);

		String path = null;
		do {
			System.out.flush();
			System.out.println("Write path File");
			path = scanner.nextLine();
		} while (path == null || path.trim().length() <= 0);

		return path;
	}

}
