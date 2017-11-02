/**
 * 
 */
/**
 * @author Damian
 *
 */
package controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.LoggerFactory;
import pages.SeleniumHomePage;

public class SeleniumHomePageController extends PageController {

	SeleniumHomePage seleniumHomePage;

	// Selenium home page controller with all the interactions that are needed
	// In this case: test will wait for 20 seconds to get as current URL: http://www.seleniumhq.org/

	public SeleniumHomePageController(WebDriver driver, int timeout,String expectedURL) {
		super(driver, timeout);
		this.logger = LoggerFactory.getLogger(SeleniumHomePageController.class.getName());
		logger.info("------------------------------");
		logger.info("Selenium Home Page initialized");
		this.seleniumHomePage = new SeleniumHomePage(driver, timeout);
		this.wait.until(ExpectedConditions.urlContains(expectedURL));
		this.logger.info("Current URL: " + this.driver.getCurrentUrl());
	}

}
