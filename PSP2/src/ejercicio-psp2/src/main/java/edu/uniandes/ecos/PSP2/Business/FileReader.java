package edu.uniandes.ecos.PSP2.Business;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;

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

	public static Path getResourcePath(String resourceName) {
		Path path = null;
		try {
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			URL url = classLoader.getResource(resourceName);
			path = Paths.get(url.toURI());
		} catch (URISyntaxException e) {
			Assert.fail("Test Fail");
			e.printStackTrace();
		}
		return path;
	}

}
