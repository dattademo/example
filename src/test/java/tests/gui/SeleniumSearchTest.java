/**
 * 
 */
/**
 * @author Damian
 *
 */
package tests.gui;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import controllers.GoogleHomePageController;
import controllers.GoogleResultPageController;
import controllers.SeleniumHomePageController;
import tests.configuration.GuiConfigLoader;

public class SeleniumSearchTest extends GuiConfigLoader {

	private int timeout = 10; // default 10 seconds
	GoogleHomePageController googleHomePageController;;
	GoogleResultPageController googleResultPageController;
	SeleniumHomePageController seleniumHomePageController;
	private Integer linkContainerIndex;
	private String expectedSeleniumURL;
	private String expectedSeleniumTitle;

	// this tests search for "Seleniumhq" page on google and verifies that the user is correctly leaded to SeleniumHQ official site 

	@Parameters({ "textToSearch" })
	@Test
	private void seleniumSearch(String textToSearch) {

		this.logger.info("****** Test initialized: Search for " + textToSearch + " Web ******");

		// test specific variables initialized
		this.timeout = Integer.parseInt(this.testDataProperties.getProperty("timeout"));
		this.linkContainerIndex = Integer.parseInt(this.testDataProperties.getProperty("linkContainerIndex"));
		this.expectedSeleniumURL = this.testDataProperties.getProperty("expectedSeleniumURL");
		this.expectedSeleniumTitle = this.testDataProperties.getProperty("expectedSeleniumTitle");

		// start google home page controller
		this.googleHomePageController = new GoogleHomePageController(this.driver, this.timeout);

		this.googleHomePageController.sendTextToInputField(textToSearch);
		this.googleHomePageController.startSearch();

		// start google result page controller
		this.googleResultPageController = new GoogleResultPageController(this.driver, this.timeout);
		this.googleResultPageController.clickOnLink(this.linkContainerIndex);

		// start Selenium home page controller
		this.seleniumHomePageController = new SeleniumHomePageController(this.driver, this.timeout,
				this.expectedSeleniumURL);

		// verify that URL and Title are correct
		Assert.assertTrue(this.driver.getTitle().contains(this.expectedSeleniumTitle));
		Assert.assertTrue(this.driver.getCurrentUrl().contains(this.expectedSeleniumURL));

	}
}
