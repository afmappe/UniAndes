package edu.uniandes.ecos.PSP2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

	public String FileToString(Path path) throws IOException {
		byte[] data = Files.readAllBytes(path);
		String content = new String(data);
		return content;
	}

}
