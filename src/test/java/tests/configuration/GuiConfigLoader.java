/**
 * 
 */
/**
 * @author Damian
 *
 */
package tests.configuration;

import java.util.Properties;

import utils.Screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class GuiConfigLoader {

	protected Screenshot screenshot;
	protected String browser;
	protected String baseURL;
	protected Properties testDataProperties;

	protected WebDriver driver;
	protected Logger logger = LoggerFactory.getLogger(GuiConfigLoader.class.getName());
	protected int timeout;
	private ChromeOptions options;

	@Parameters({ "browser" })
	@BeforeMethod
	// test data and browser configuration
	public void buildConfiguration(String browser) {
		this.browser = browser;

		this.testDataProperties = PropertiesLoader
				.loadProperties("./src/test/java/resources/configData/generalTestData.properties");
		this.timeout = Integer.parseInt(this.testDataProperties.getProperty("timeout"));
		this.baseURL = this.testDataProperties.getProperty("baseURL");

		initDriver();

	}

	// starts driver at the base URL setted on generalTestData.properties
	public void initDriver() {
		startBrowser();
		this.driver.manage().window().maximize();
		this.driver.get(this.baseURL);
		this.logger.info("-- Browser initialized --");
	}

	// select which browser is going to start based on the xml test file
	private void startBrowser() {
		switch (this.browser.toLowerCase()) {
		case "chrome":
			this.chromeStart();
			break;
		case "firefox":
			this.driver = new FirefoxDriver();
			break;
		case "ie":
			this.driver = new InternetExplorerDriver();
			break;
		default:
			this.chromeStart();
			break;
		}
	}

	// chrome has specific start sequence to avoid infobars
	private void chromeStart() {
		this.options = new ChromeOptions();
		this.options.addArguments("disable-infobars");
		this.options.addArguments("start-maximized");
		this.driver = new ChromeDriver(this.options);
	}

	// this method closes the browser, if an error occurs: a screenshot is taken
	@AfterMethod
	public void closeDriver(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				this.logger.info("****** TEST SUCCEEDED ******");

			} else if (result.getStatus() == ITestResult.FAILURE) {
				this.logger.info("****** TEST FAILED ******");
				screenshot = new Screenshot();

				screenshot.takeScreenShoot(this.driver, result.getName());

			} else if (result.getStatus() == ITestResult.SKIP) {
				this.logger.info("****** TEST SKIPED ******");

			}
		} catch (Exception e) {
			this.logger.error("\nLog Message::@AfterMethod: Exception caught");
			e.printStackTrace();
		}
		this.driver.quit();
		this.logger.info("-- Browser closed --");
	}

}
