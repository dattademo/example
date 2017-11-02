/**
 * 
 */
/**
 * @author Damian
 *
 */
package controllers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import pages.GoogleResultPage;

public class GoogleResultPageController extends PageController {

	GoogleResultPage resultPage;
	WebElement resultCluster;

	// Google Result page controller with all the interactions that are needed
	public GoogleResultPageController(WebDriver driver, int timeout) {
		super(driver, timeout);
		this.logger = LoggerFactory.getLogger(GoogleResultPageController.class.getName());
		logger.info("------------------------------");
		logger.info("Google Result Page initialized");
		this.resultPage = new GoogleResultPage(driver, timeout);
	}

	// Get the result by index (0: first result on screen) and click on this link
	public void clickOnLink(Integer linkContainerIndex) {
		
		this.resultCluster = this.resultPage.mainContainer
				.findElements(By.className(this.resultPage.resultContainerClassName)).get(linkContainerIndex)
				.findElement(By.className(this.resultPage.firstLinkContainerClassName))
				.findElement(By.tagName(this.resultPage.linkTagName));
		
		this.logger.info("Result Title #" + (linkContainerIndex + 1) + ": " + this.resultCluster.getText());

		this.logger.info("Click on selected item");
		this.resultCluster.click();

	}
}
