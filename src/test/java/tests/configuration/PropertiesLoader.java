/**
 * 
 */
/**
 * @author Damian
 *
 */
package tests.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesLoader {

	private static Properties currentPropertiesFile;
	private static Logger logger = LoggerFactory.getLogger(PropertiesLoader.class.getName());
	
	// this class is needed to load all properties for the test
	public static Properties loadProperties(String propertyPath) {
		try {
			File file = new File(propertyPath);
			FileInputStream fileInput = new FileInputStream(file);
			currentPropertiesFile = new Properties();
			currentPropertiesFile.load(fileInput);
			fileInput.close();

		} catch (FileNotFoundException e) {
			logger.error("File : " + propertyPath + " not found");
			e.printStackTrace();

		} catch (IOException e) {
			logger.error("File : " + propertyPath + " cannot be processed");
			e.printStackTrace();
		}
		return currentPropertiesFile;

	}

}
