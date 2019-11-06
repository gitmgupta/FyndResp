package org.restapi.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	protected static String currentDirectory = System.getProperty("user.dir");

	String configFilePath = currentDirectory + "\\src\\main\\java\\org\\restapi\\config\\config.properties";
	protected static Properties prop;

	public int RESPONSE_STATUS_CODE_200 = 200;
	public int RESPONSE_STATUS_CODE_201 = 201;
	public int RESPONSE_STATUS_CODE_400 = 400;
	public int RESPONSE_STATUS_CODE_204 = 204;
	public int RESPONSE_STATUS_CODE_502 = 502;

	public TestBase() {
		try {
			prop = new Properties();
			System.out.println();
			FileInputStream file = new FileInputStream(configFilePath);
			prop.load(file);
		} catch (FileNotFoundException e) {
			System.out.println("File Not found" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exeption " + e.getMessage());
		}
	}
}