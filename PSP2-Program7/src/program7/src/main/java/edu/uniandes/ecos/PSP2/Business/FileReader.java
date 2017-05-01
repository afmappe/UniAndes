package edu.uniandes.ecos.PSP2.Business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {

	public static Path pathFromString(String stringPath) {
		Path path = Paths.get(stringPath);
		return path;
	}

	public static String fileToString(Path path) throws IOException {
		byte[] data = Files.readAllBytes(path);
		String content = new String(data);
		return content;
	}

}
