/**
 * 
 */
/**
 * @author Damian
 *
 */
package controllers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import pages.GoogleHomePage;

public class GoogleHomePageController extends PageController {

	GoogleHomePage homePage;

	// Google home page controller with all the interactions that are needed
	
	public GoogleHomePageController(WebDriver driver, int timeout) {
		super(driver, timeout);
		this.logger = LoggerFactory.getLogger(GoogleHomePageController.class.getName());
		logger.info("----------------------------");
		logger.info("Google Home Page initialized");
		this.homePage = new GoogleHomePage(driver, timeout);
	}

	// send the search text to the input field 
	public void sendTextToInputField(String textToSearch) {
		this.logger.info("Send text: '" + textToSearch + "' to search box");
		this.homePage.searchInput.sendKeys(textToSearch);
	}

	// press ENTER button
	public void startSearch() {
		this.logger.info("Press ENTER Key");
		this.homePage.searchInput.sendKeys(Keys.ENTER);
	}
	
}
