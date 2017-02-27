package edu.uniandes.ecos.PSP2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CsvFileReader {

	Temp t = new Temp();

	public void Test(String filePath) throws IOException {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();

		String str = new String(data, "UTF-8");
		String[] lines = str.split(System.getProperty("line.separator"));
	}

	public void Reader(String filePath) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filePath));
		while (scanner.hasNext()) {
			String line = scanner.next();
			String[] attributes = line.split(";");

			if (attributes != null && attributes.length == 2) {

			}
		}
		scanner.close();
	}
}
