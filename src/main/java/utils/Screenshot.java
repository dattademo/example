/**
 * 
 */
/**
 * @author Damian
 *
 */
package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


// Screenshot is taken if fail occurs in order to see the issue
public class Screenshot {
	protected String nameScreenshot;
	protected String path;
	protected Logger logger = LoggerFactory.getLogger(Screenshot.class.getName());

	public void takeScreenShoot(WebDriver driver, String methodName) throws IOException {
		nameScreenshot = methodName;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		path = getPath(nameScreenshot);
		FileUtils.copyFile(scrFile, new File(path));
		logger.info("Screenshot path: " + path );
	}
	
	private String getPath(String nameTest) throws IOException {
		File directory = new File(".");
		String newFileNamePath = directory.getCanonicalPath() + "/target/surefire-reports/screenShots/" + nameTest + "/" + getFileName(nameTest);
		return newFileNamePath;
	}

	private String getFileName(String testName) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-hh.mm.sss");
		Date date = new Date();
		return dateFormat.format(date) + "-" + testName + ".png";
	}

}
